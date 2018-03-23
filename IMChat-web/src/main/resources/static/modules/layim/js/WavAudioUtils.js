navigator.getUserMedia =
    navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia ||
    navigator.msGetUserMedia ||
    window.getUserMedia;

var AudioContext = window.AudioContext || window.webkitAudioContext;
var audioContext = new AudioContext;
if (audioContext.createScriptProcessor == null)
    audioContext.createScriptProcessor = audioContext.createJavaScriptNode;
var processor = undefined;
var worker = new Worker('js/WavEncoderWorker.js');
var encoder = undefined;
var encodingProcess = 'separate';       // separate | background | direct
var microphone = undefined;
var finishRecordingCallback = undefined;
var numChannels = 1;

function getBuffers(event) {
    var buffers = [];
    for (var ch = 0; ch < numChannels; ++ch)
        buffers[ch] = event.inputBuffer.getChannelData(ch);
    return buffers;
}

function startRecording(onSuccess, onError) {
    navigator.getUserMedia({ audio: true },
        function(stream) {
            microphone = audioContext.createMediaStreamSource(stream);

            try {
                processor = audioContext.createScriptProcessor(undefined, numChannels, numChannels);
            } catch (e) {
                processor = audioContext.createScriptProcessor(4096, numChannels, numChannels);
            }
            microphone.connect(processor);
            processor.connect(audioContext.destination);

            if (encodingProcess === 'direct') {
                encoder = new WavAudioEncoder(audioContext.sampleRate, numChannels);
                processor.onaudioprocess = function(event) {
                    encoder.encode(getBuffers(event));
                };
            } else {
                worker.postMessage({
                    command: 'start',
                    process: encodingProcess,
                    sampleRate: audioContext.sampleRate,
                    numChannels: numChannels
                });
                processor.onaudioprocess = function(event) {
                    worker.postMessage({ command: 'record', buffers: getBuffers(event) });
                };
            }

            if (onSuccess) {
                onSuccess();
            }
        },
        function(error) {
            if (onError) {
                onError(error);
            }
        }
    );
}

function stopRecording(onFinish) {
    finishRecordingCallback = onFinish;

    microphone.disconnect();
    processor.disconnect();

    closeStream(microphone.mediaStream);

    if (encodingProcess === 'direct')
        if (onFinish)
            onFinish(encoder.finish());
        else
            encoder.cancel();
    else
        worker.postMessage({ command: onFinish ? 'finish' : 'cancel' });
}

worker.onmessage = function(event) {
    if (finishRecordingCallback) {
        finishRecordingCallback(event.data.blob);
    }
};

function closeStream(stream) {
    if (typeof stream.stop === 'function') {
        stream.stop();
    }
    else {
        let trackList = [stream.getAudioTracks(), stream.getVideoTracks()];

        for (let i = 0; i < trackList.length; i++) {
            let tracks = trackList[i];
            if (tracks && tracks.length > 0) {
                for (let j = 0; j < tracks.length; j++) {
                    let track = tracks[j];
                    if (typeof track.stop === 'function') {
                        track.stop();
                    }
                }
            }
        }
    }
}