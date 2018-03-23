navigator.getUserMedia =
    navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia ||
    navigator.msGetUserMedia ||
    window.getUserMedia;

var mediaStream = undefined;
var onFinishCallback = undefined;
var mediaRecorder = undefined;

function startRecording(onSuccess, onError) {
    navigator.getUserMedia({ audio: true },
        function(stream) {
            mediaStream = stream;
            onFinishCallback = undefined;

            mediaRecorder = new MediaStreamRecorder(stream);
            mediaRecorder.mimeType = 'audio/wav'; // check this line for audio/wav
            mediaRecorder.audioChannels = 1;
            mediaRecorder.ondataavailable = function (blob) {
                if (onFinishCallback) {
                    onFinishCallback(blob)
                }
            };
            mediaRecorder.start(1000 * 60 * 60);

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
    onFinishCallback = onFinish;
    mediaRecorder.stop();
    closeStream(mediaStream);
}

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