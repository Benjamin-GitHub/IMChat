﻿(function (root, factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as an anonymous module.
        define(['exports', 'echarts'], factory);
    } else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {
        // CommonJS
        factory(exports, require('echarts'));
    } else {
        // Browser globals
        factory({}, root.echarts);
    }
}(this, function (exports, echarts) {
    var log = function (msg) {
        if (typeof console !== 'undefined') {
            console && console.error && console.error(msg);
        }
    }
    if (!echarts) {
        log('ECharts is not Loaded');
        return;
    }
    if (!echarts.registerMap) {
        log('ECharts Map is not loaded')
        return;
    }
    echarts.registerMap('南阳市', {"type": "FeatureCollection", "features": [{"type":"Feature","properties":{"name":"邓州市"},"geometry":{"type":"MultiPolygon","coordinates":[[[[111.980269804688,32.911782453125],[112.002345,32.9079811835938],[112.029117460938,32.9125905585938],[112.033206816406,32.888843],[112.030999785156,32.8760280585938],[112.097235136719,32.8874318671875],[112.111776152344,32.8678835273437],[112.130582304688,32.8711232734375],[112.165394316406,32.8495778632813],[112.223079863281,32.8581081367188],[112.272122832031,32.8798024726562],[112.297345,32.8738430000001],[112.300704375,32.8672023750001],[112.327205839844,32.8537966132813],[112.315504179688,32.8298342109375],[112.333985625,32.8204836250001],[112.337345,32.813843],[112.333260527344,32.7879274726563],[112.304029570313,32.7430373359375],[112.32408328125,32.7291896796875],[112.311429472656,32.7097585273438],[112.296654082031,32.6702712226563],[112.281429472656,32.6597585273438],[112.273260527344,32.6479274726563],[112.243260527344,32.6272145820313],[112.267840605469,32.5992702460938],[112.295921660156,32.5887624335938],[112.275355253906,32.5050270820313],[112.288099394531,32.4481716132813],[112.261429472656,32.4297585273438],[112.253260527344,32.4179274726563],[112.231429472656,32.4097585273438],[112.227345,32.3838430000001],[112.202183867188,32.3944118476563],[112.171571074219,32.3875490546876],[112.163260527344,32.4097585273438],[112.133260527344,32.4135671210938],[112.153616972656,32.3995143867188],[112.149796171875,32.3824782539062],[112.123260527344,32.3997585273437],[112.101429472656,32.4079274726563],[112.059830351563,32.4426198554688],[112.063863554688,32.4606130195313],[112.0437903125,32.4779274726563],[112.007345,32.453843],[111.975355253906,32.4714015937501],[111.94310671875,32.5270241523438],[111.913170195313,32.5080178046875],[111.874671660156,32.4996681953125],[111.853170195313,32.5296681953125],[111.781519804688,32.5480178046875],[111.772965117188,32.5599538398438],[111.756761503906,32.5567507148438],[111.733170195313,32.5896681953126],[111.693651152344,32.617993390625],[111.642345,32.6078542304688],[111.627843046875,32.6107204414063],[111.637345,32.633843],[111.672799101563,32.6418971992188],[111.704610625,32.6379396796875],[111.721790800781,32.6593971992187],[111.802318144531,32.669468],[111.827345,32.6663552070312],[111.860084257813,32.6704274726563],[111.871790800781,32.7031447578125],[111.821331816406,32.7386135078126],[111.837117949219,32.7654689765625],[111.831241484375,32.8127150703125],[111.80068484375,32.83718284375],[111.787345,32.8838430000001],[111.799176054688,32.8920119453125],[111.815513945313,32.9156740546875],[111.833616972656,32.9281716132813],[111.830553007813,32.9418361640626],[111.908428984375,32.9618190742188],[111.884918242188,32.9979274726563],[111.923260527344,32.9897585273438],[111.977345,32.963843],[111.985667753906,32.943139875],[111.980269804688,32.911782453125]]]]}},{"type":"Feature","properties":{"name":"方城县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[112.856402617188,33.6163710761719],[112.917345,33.6073647285156],[112.932857695313,33.6096572089844],[112.948807402344,33.5889931464844],[113.00170046875,33.5681996894532],[113.017345,33.5638430000001],[113.021790800781,33.5482900214844],[113.040848417969,33.5158705878907],[113.043587675781,33.4938430000001],[113.037530546875,33.4451345039063],[113.085206328125,33.4510646796875],[113.112899199219,33.4393959785157],[113.131986113281,33.4281764960937],[113.180985136719,33.4342714667969],[113.206239042969,33.4027370429688],[113.223023710938,33.3892958808594],[113.220799589844,33.3714174628907],[113.305162382813,33.3473281074219],[113.328968535156,33.3502883125],[113.381790800781,33.3382900214844],[113.387345,33.3338430000001],[113.395936308594,33.3109792304687],[113.377642851563,33.2957839179687],[113.401663847656,33.253843],[113.374676542969,33.2067250800782],[113.371363554688,33.1742226386719],[113.381883574219,33.1383803535157],[113.387345,33.133843],[113.353980742188,33.0921779609376],[113.251790800781,33.0793971992187],[113.212264433594,33.0681081367188],[113.197345,33.0738430000001],[113.181207304688,33.1459609199219],[113.148563261719,33.1584706855469],[113.1073840625,33.1354958320312],[113.09271609375,33.1184706855469],[113.079947539063,33.1092153144531],[113.06271609375,33.1292153144532],[113.05197390625,33.1384706855469],[113.042474394531,33.1494948554688],[113.021363554688,33.1377162910157],[113.002020292969,33.1392702460938],[112.992474394531,33.1281911445313],[112.972623320313,33.1392665839844],[112.959742460938,33.1382326484376],[112.933409453125,33.1076686835938],[112.904483671875,33.1238088203125],[112.862579375,33.1084206367188],[112.797345,33.1138430000001],[112.787345,33.1277956367188],[112.770484648438,33.1042702460938],[112.724920683594,33.1132741523438],[112.713170195313,33.1296681953125],[112.697554960938,33.1408608222656],[112.663053007813,33.1340431953125],[112.652943144531,33.1602529121094],[112.637345,33.1538430000001],[112.637345,33.163843],[112.627345,33.163843],[112.633260527344,33.1879274726563],[112.637345,33.213843],[112.6600403125,33.2295131660156],[112.650103789063,33.273843],[112.653616972656,33.2895131660157],[112.641073027344,33.2981728339844],[112.649854765625,33.3373403144531],[112.665574980469,33.3614821601563],[112.682345,33.3577223945312],[112.697345,33.3610842109376],[112.716859160156,33.3567104316407],[112.741429472656,33.3997585273438],[112.782166777344,33.4150014472656],[112.791429472656,33.4397585273438],[112.803260527344,33.4579274726562],[112.811429472656,33.4797585273438],[112.836158476563,33.4968325019532],[112.831124296875,33.5192897773438],[112.843260527344,33.5379274726562],[112.847345,33.583843],[112.856402617188,33.6163710761719]]]]}},{"type":"Feature","properties":{"name":"南召县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[112.247345,33.7238430000001],[112.251429472656,33.7179274726563],[112.303260527344,33.6997585273438],[112.320440703125,33.6748744941407],[112.367345,33.6643593574219],[112.416119414063,33.6752931953125],[112.451429472656,33.6479274726562],[112.494547148438,33.6368617988282],[112.527069121094,33.5897585273438],[112.562171660156,33.6007070136719],[112.592425566406,33.6204067207032],[112.621839628906,33.5976088691406],[112.644097929688,33.6025991035157],[112.691429472656,33.5879274726563],[112.733260527344,33.5797585273437],[112.767345,33.5654433417969],[112.802066679688,33.5800258613281],[112.825662871094,33.5747365546875],[112.847345,33.583843],[112.843260527344,33.5379274726562],[112.831124296875,33.5192897773438],[112.836158476563,33.4968325019532],[112.811429472656,33.4797585273438],[112.803260527344,33.4579274726562],[112.791429472656,33.4397585273438],[112.782166777344,33.4150014472656],[112.741429472656,33.3997585273438],[112.716859160156,33.3567104316407],[112.697345,33.3610842109376],[112.682345,33.3577223945312],[112.665574980469,33.3614821601563],[112.649854765625,33.3373403144531],[112.641073027344,33.2981728339844],[112.653616972656,33.2895131660157],[112.650103789063,33.273843],[112.6600403125,33.2295131660156],[112.637345,33.213843],[112.600499296875,33.2228932929687],[112.582847929688,33.1973305488282],[112.552623320313,33.2100258613282],[112.541673613281,33.2075722480469],[112.533260527344,33.2197585273438],[112.521073027344,33.2281728339844],[112.525706816406,33.248843],[112.501051054688,33.2580690742187],[112.503616972656,33.2695131660156],[112.483802519531,33.2831935859376],[112.457647734375,33.2453151679688],[112.422623320313,33.2600258613282],[112.394105253906,33.2536330390626],[112.379176054688,33.2320119453125],[112.353802519531,33.2144924140625],[112.342345,33.2310842109375],[112.333260527344,33.2179274726563],[112.317345,33.213843],[112.281783476563,33.2080007148438],[112.27298953125,33.2294863105469],[112.24845828125,33.2484206367188],[112.237345,33.313843],[112.237345,33.323843],[112.231832304688,33.3309841132812],[112.212345,33.3281044746094],[112.201954375,33.3296401191406],[112.182713652344,33.3180324531251],[112.147345,33.323843],[112.111429472656,33.3479274726563],[112.103260527344,33.3597585273438],[112.081051054688,33.3680690742188],[112.086151152344,33.3908168769531],[112.069249296875,33.3870278144532],[112.053011503906,33.4304238105469],[112.010860625,33.412719953125],[111.986461210938,33.4779323554688],[111.946319609375,33.5008437324219],[111.930186796875,33.5242116523438],[111.933638945313,33.5396169257813],[111.911429472656,33.5479274726563],[111.907345,33.5638430000001],[111.922154570313,33.5690334296875],[112.002374296875,33.5881423164063],[112.015079375,33.6282704902344],[112.052181425781,33.608637921875],[112.062345,33.6090407539063],[112.088367949219,33.6080092597657],[112.069757109375,33.6431825996094],[112.109329863281,33.6618581367188],[112.131190214844,33.7081813789063],[112.169991484375,33.7217800117188],[112.191065703125,33.6990334296875],[112.202535429688,33.7086525703125],[112.212523222656,33.7194301582032],[112.232496367188,33.7186391425782],[112.247345,33.7238430000001]],[[112.385152617188,33.2772658515626],[112.397345,33.273843],[112.393922148438,33.2860353828125],[112.385152617188,33.2772658515626]]]]}},{"type":"Feature","properties":{"name":"内乡县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[111.946319609375,33.5008437324219],[111.986461210938,33.4779323554688],[112.010860625,33.412719953125],[112.053011503906,33.4304238105469],[112.069249296875,33.3870278144532],[112.086151152344,33.3908168769531],[112.081051054688,33.3680690742188],[112.103260527344,33.3597585273438],[112.111429472656,33.3479274726563],[112.147345,33.323843],[112.139522734375,33.2978639960938],[112.122020292969,33.2992702460938],[112.11271609375,33.288470685547],[112.0619153125,33.2691933417969],[112.064857207031,33.232563703125],[112.05271609375,33.2184706855469],[112.025858183594,33.1953310371094],[112.00271609375,33.1684706855469],[111.991165800781,33.1585195136719],[111.993424101563,33.1303993964844],[111.981265898438,33.0972866035157],[111.982772246094,33.0785182929687],[111.970738554688,33.068149640625],[111.993524199219,33.0485182929688],[111.991917753906,33.0285182929688],[112.00681765625,33.0156838203126],[111.977345,32.963843],[111.923260527344,32.9897585273438],[111.884918242188,32.9979274726563],[111.908428984375,32.9618190742188],[111.830553007813,32.9418361640626],[111.833616972656,32.9281716132813],[111.815513945313,32.9156740546875],[111.799176054688,32.8920119453125],[111.787345,32.8838430000001],[111.773463164063,32.9005568671876],[111.731009550781,32.8669557929688],[111.735855742188,32.8194069648437],[111.671561308594,32.8702931953125],[111.651998320313,32.8682985664062],[111.620994902344,32.8906081367188],[111.622886992188,32.909165265625],[111.611883574219,32.9283815742188],[111.601658964844,32.9519533515625],[111.577642851563,32.9719020820313],[111.598800078125,33.008843],[111.5815246875,33.0390065742188],[111.592894316406,33.048452375],[111.59150515625,33.0620803046875],[111.571795683594,33.0784523750001],[111.572855253906,33.088843],[111.571834746094,33.098843],[111.572855253906,33.1088430000001],[111.571834746094,33.118843],[111.573372832031,33.133930890625],[111.597345,33.1538430000001],[111.602625761719,33.1491237617188],[111.612064238281,33.1285622382813],[111.642625761719,33.1191237617188],[111.654188261719,33.1061855292969],[111.694193144531,33.0891237617188],[111.712064238281,33.1091237617187],[111.751419707031,33.1271865058594],[111.772064238281,33.1506923652344],[111.752064238281,33.1685622382813],[111.730640898438,33.2152394843751],[111.732655058594,33.2490444160157],[111.7215246875,33.2800661445313],[111.722940703125,33.3038430000001],[111.721749296875,33.323843],[111.722642851563,33.3388430000001],[111.721995878906,33.3497158027344],[111.6826575,33.3473720527344],[111.642625761719,33.3691237617188],[111.611717558594,33.3833107734375],[111.613238554688,33.4088430000001],[111.611195097656,33.4431154609376],[111.635260039063,33.4785622382813],[111.688521757813,33.4496181464844],[111.702064238281,33.4791237617188],[111.727701445313,33.5158278632813],[111.752064238281,33.4885622382813],[111.776624785156,33.4791237617188],[111.802064238281,33.5191237617188],[111.823819609375,33.5291091132813],[111.821011992188,33.5761952949219],[111.827345,33.593843],[111.900560332031,33.5863747382813],[111.907345,33.5638430000001],[111.911429472656,33.5479274726563],[111.933638945313,33.5396169257813],[111.930186796875,33.5242116523438],[111.946319609375,33.5008437324219]]]]}},{"type":"Feature","properties":{"name":"社旗县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[113.181207304688,33.1459609199219],[113.197345,33.0738430000001],[113.191429472656,33.0697585273438],[113.183260527344,33.0579274726563],[113.148753691406,33.045014875],[113.11466921875,33.0010378242188],[113.088407011719,32.9430886054688],[113.122345,32.9354811835938],[113.146246367188,32.9408376289062],[113.181898222656,32.917622296875],[113.201429472656,32.9219997382813],[113.192882109375,32.8863454414062],[113.173260527344,32.8579274726563],[113.161429472656,32.8497585273438],[113.157345,32.833843],[113.14263796875,32.82806175],[113.132345,32.8295827460938],[113.106551542969,32.8257692695313],[113.0858215625,32.7989138007813],[113.048426542969,32.7894875312501],[113.030809355469,32.812309796875],[112.976900664063,32.8043434882813],[112.94216921875,32.830093],[112.931627226563,32.8164357734375],[112.832476835938,32.8554128242187],[112.822542753906,32.8910890937501],[112.792857695313,32.8867018867188],[112.78298953125,32.89948753125],[112.777345,32.903843],[112.76978640625,32.921841046875],[112.791429472656,32.9597585273438],[112.824932890625,32.9722951484375],[112.821224394531,32.988843],[112.823638945313,32.9996169257813],[112.787594023438,33.0131032539063],[112.767789335938,33.0435182929688],[112.773465605469,33.0688430000001],[112.770943632813,33.0800905585938],[112.791429472656,33.1097585273438],[112.797345,33.1138430000001],[112.862579375,33.1084206367188],[112.904483671875,33.1238088203125],[112.933409453125,33.1076686835938],[112.959742460938,33.1382326484376],[112.972623320313,33.1392665839844],[112.992474394531,33.1281911445313],[113.002020292969,33.1392702460938],[113.021363554688,33.1377162910157],[113.042474394531,33.1494948554688],[113.05197390625,33.1384706855469],[113.06271609375,33.1292153144532],[113.079947539063,33.1092153144531],[113.09271609375,33.1184706855469],[113.1073840625,33.1354958320312],[113.148563261719,33.1584706855469],[113.181207304688,33.1459609199219]]]]}},{"type":"Feature","properties":{"name":"唐河县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[113.017345,32.513843],[113.017345,32.523843],[113.030152617188,32.518843],[113.017345,32.513843]]],[[[113.247345,32.673843],[113.260794707031,32.6667580390625],[113.251627226563,32.6408937812501],[113.247345,32.673843]]],[[[112.637345,32.673843],[112.625152617188,32.6772658515626],[112.633922148438,32.6860353828125],[112.637345,32.673843]]],[[[113.197345,32.713843],[113.200767851563,32.7260353828125],[113.209537382813,32.7172658515626],[113.197345,32.713843]]],[[[113.197345,32.713843],[113.200704375,32.7072023750001],[113.233985625,32.7004836250001],[113.247345,32.673843],[113.210499296875,32.6828932929687],[113.193260527344,32.6579274726562],[113.18060671875,32.6491896796875],[113.195233183594,32.6267287421876],[113.191214628906,32.6088014960938],[113.197345,32.583843],[113.171883574219,32.5883815742188],[113.152806425781,32.5993044257813],[113.055819121094,32.6083815742188],[113.03951296875,32.570786359375],[113.019058867188,32.6179470039063],[112.996683378906,32.5910060859375],[113.023363066406,32.568843],[113.011754179688,32.5591970039063],[113.017345,32.523843],[112.994100371094,32.518843],[113.017345,32.513843],[113.020704375,32.497202375],[113.034989042969,32.4792214179688],[113.01740359375,32.443843],[113.027345,32.4238430000001],[112.993829375,32.4184255195313],[112.983170195313,32.3780178046876],[112.967503691406,32.3696681953125],[112.952965117188,32.3899538398438],[112.937345,32.3868679023438],[112.907345,32.3927956367188],[112.877345,32.3868679023438],[112.844205351563,32.3934157539063],[112.833170195313,32.3780178046876],[112.801519804688,32.3696681953125],[112.782777128906,32.35776878125],[112.771724882813,32.3599538398438],[112.7582434375,32.3411452460938],[112.712633085938,32.359887921875],[112.695303984375,32.3564626289063],[112.663170195313,32.3696681953125],[112.571519804688,32.3880178046875],[112.545162382813,32.404751203125],[112.533170195313,32.3880178046875],[112.517345,32.3838430000001],[112.487345,32.3838430000001],[112.477345,32.3838430000001],[112.471265898438,32.3993093085938],[112.493167753906,32.4082717109376],[112.491605253906,32.4188430000001],[112.493387480469,32.4309059882813],[112.522542753906,32.42659690625],[112.533558378906,32.4661550117188],[112.563167753906,32.4782717109376],[112.559954863281,32.500014875],[112.58298953125,32.53819846875],[112.595611601563,32.5835256171876],[112.587345,32.633843],[112.596927519531,32.6711794257813],[112.63033328125,32.6636891914063],[112.637345,32.673843],[112.649100371094,32.6832570625],[112.628526640625,32.736782453125],[112.643023710938,32.7483888984375],[112.641666289063,32.7592971015626],[112.652899199219,32.7682888007813],[112.661790800781,32.8393971992188],[112.72525515625,32.8504396796875],[112.717686796875,32.9112966132813],[112.777345,32.903843],[112.78298953125,32.89948753125],[112.792857695313,32.8867018867188],[112.822542753906,32.8910890937501],[112.832476835938,32.8554128242187],[112.931627226563,32.8164357734375],[112.94216921875,32.830093],[112.976900664063,32.8043434882813],[113.030809355469,32.812309796875],[113.048426542969,32.7894875312501],[113.0858215625,32.7989138007813],[113.106551542969,32.8257692695313],[113.132345,32.8295827460938],[113.14263796875,32.82806175],[113.157345,32.833843],[113.173714628906,32.8302126289063],[113.180975371094,32.7674733710938],[113.197664824219,32.7579592109375],[113.183922148438,32.7214968085938],[113.197345,32.713843]]]]}},{"type":"Feature","properties":{"name":"桐柏县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[113.550501738281,32.3277809882813],[113.557345,32.303843],[113.532899199219,32.3108327460938],[113.550501738281,32.3277809882813]]],[[[113.017345,32.513843],[112.994100371094,32.518843],[113.017345,32.523843],[113.017345,32.513843]]],[[[113.597345,32.363843],[113.593922148438,32.3760353828125],[113.585152617188,32.3672658515626],[113.588250761719,32.3520607734375],[113.55298953125,32.33819846875],[113.52170046875,32.32948753125],[113.493631621094,32.3125563789063],[113.46170046875,32.2994875312501],[113.417345,32.27272971875],[113.372735625,32.2996388984376],[113.352564726563,32.2966579414063],[113.310867949219,32.328843],[113.329080839844,32.3429006171876],[113.29170046875,32.3581984687501],[113.277913847656,32.3760622382813],[113.23170046875,32.40819846875],[113.208546171875,32.4381984687501],[113.1595325,32.4186208320313],[113.142916289063,32.3780202460937],[113.132203398438,32.3796022773437],[113.107345,32.373843],[113.102576933594,32.4075075507812],[113.072345,32.3971266914063],[113.053397246094,32.4036330390625],[113.043624296875,32.420122296875],[113.027345,32.4238430000001],[113.01740359375,32.443843],[113.034989042969,32.4792214179688],[113.020704375,32.497202375],[113.017345,32.513843],[113.030152617188,32.518843],[113.017345,32.523843],[113.011754179688,32.5591970039063],[113.023363066406,32.568843],[112.996683378906,32.5910060859375],[113.019058867188,32.6179470039063],[113.03951296875,32.570786359375],[113.055819121094,32.6083815742188],[113.152806425781,32.5993044257813],[113.171883574219,32.5883815742188],[113.197345,32.583843],[113.202064238281,32.5785622382813],[113.224193144531,32.5691237617188],[113.244620390625,32.5919850898438],[113.302345,32.5885451484375],[113.312569609375,32.5891555],[113.332064238281,32.5785622382813],[113.355260039063,32.5691237617188],[113.399310332031,32.6184255195313],[113.442108183594,32.5885305],[113.452545195313,32.5891530585938],[113.494449492188,32.5741188789063],[113.522064238281,32.5891237617188],[113.546236601563,32.600219953125],[113.576783476563,32.6344045234375],[113.592625761719,32.6485622382813],[113.602078886719,32.6691579414063],[113.613858671875,32.6684548164063],[113.611429472656,32.7091945625],[113.63209109375,32.70796409375],[113.637345,32.713843],[113.661429472656,32.6979274726562],[113.703260527344,32.6897585273438],[113.740819121094,32.6606496406251],[113.783648710938,32.6496584296876],[113.779132109375,32.6295143867188],[113.793260527344,32.6197585273438],[113.797345,32.603843],[113.77271609375,32.56847190625],[113.761165800781,32.5585182929688],[113.763048125,32.535102765625],[113.75271609375,32.4784719062501],[113.736600371094,32.4645876289063],[113.707345,32.413843],[113.682183867188,32.4244118476562],[113.645804472656,32.416255109375],[113.613260527344,32.3679274726563],[113.597345,32.363843]]]]}},{"type":"Feature","properties":{"name":"西峡县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[111.147345,33.343843],[111.141783476563,33.3308461738281],[111.124620390625,33.3398378730469],[111.147345,33.343843]]],[[[111.147345,33.343843],[111.1282434375,33.3779628730469],[111.112857695313,33.3580287910157],[111.102345,33.3595815253906],[111.092345,33.3581044746094],[111.063880644531,33.3623110175782],[111.045894804688,33.339009015625],[111.027345,33.3338430000001],[111.023260527344,33.3797585273438],[111.006434355469,33.4055959296875],[110.999132109375,33.4381728339844],[111.017135039063,33.4506020332032],[111.027674589844,33.4976222968751],[110.99611453125,33.54608909375],[111.007345,33.553843],[111.060247832031,33.558891828125],[111.10406375,33.5768251777344],[111.12298953125,33.6081996894532],[111.13170046875,33.6294863105469],[111.143377714844,33.648843],[111.125660429688,33.6782118964844],[111.179837675781,33.6896437812501],[111.195845976563,33.783891828125],[111.223922148438,33.8008266425782],[111.24263796875,33.7980605292969],[111.257345,33.803843],[111.262042265625,33.7874123359376],[111.314508085938,33.7672463203126],[111.333917265625,33.7696608710938],[111.400179472656,33.7581288886719],[111.481497832031,33.7268715644531],[111.5389075,33.7340126777344],[111.639146757813,33.7165688300782],[111.661790800781,33.6882900214844],[111.749241972656,33.67556175],[111.797345,33.653843],[111.830887480469,33.6365041328125],[111.817025175781,33.5997280097656],[111.827345,33.593843],[111.821011992188,33.5761952949219],[111.823819609375,33.5291091132813],[111.802064238281,33.5191237617188],[111.776624785156,33.4791237617188],[111.752064238281,33.4885622382813],[111.727701445313,33.5158278632813],[111.702064238281,33.4791237617188],[111.688521757813,33.4496181464844],[111.635260039063,33.4785622382813],[111.611195097656,33.4431154609376],[111.613238554688,33.4088430000001],[111.611717558594,33.3833107734375],[111.642625761719,33.3691237617188],[111.6826575,33.3473720527344],[111.721995878906,33.3497158027344],[111.722642851563,33.3388430000001],[111.721749296875,33.323843],[111.722940703125,33.3038430000001],[111.7215246875,33.2800661445313],[111.732655058594,33.2490444160157],[111.730640898438,33.2152394843751],[111.752064238281,33.1685622382813],[111.772064238281,33.1506923652344],[111.751419707031,33.1271865058594],[111.712064238281,33.1091237617187],[111.694193144531,33.0891237617188],[111.654188261719,33.1061855292969],[111.642625761719,33.1191237617188],[111.612064238281,33.1285622382813],[111.602625761719,33.1491237617188],[111.597345,33.1538430000001],[111.592899199219,33.1693959785156],[111.581790800781,33.1782900214844],[111.568450957031,33.1949489570312],[111.547906523438,33.2114003730469],[111.522345,33.2082216621095],[111.511986113281,33.2095095039063],[111.492144804688,33.1978481269532],[111.482899199219,33.2093959785157],[111.451790800781,33.2282900214845],[111.40181765625,33.2682582832031],[111.392545195313,33.2798378730469],[111.372345,33.2679653144531],[111.350792265625,33.2806349921876],[111.331890898438,33.2570339179688],[111.312345,33.2594643378906],[111.291265898438,33.2568434882813],[111.245369902344,33.2838210273438],[111.232899199219,33.2993959785157],[111.171656523438,33.3083095527344],[111.175467558594,33.3389492011719],[111.147345,33.343843]]]]}},{"type":"Feature","properties":{"name":"新野县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[112.437345,32.353843],[112.449537382813,32.3504201484375],[112.440767851563,32.3416506171875],[112.437345,32.353843]]],[[[112.477345,32.3838430000001],[112.487345,32.3838430000001],[112.482345,32.3710353828126],[112.477345,32.3838430000001]]],[[[112.477345,32.3838430000001],[112.441429472656,32.3597585273438],[112.437345,32.353843],[112.411790800781,32.3582888007813],[112.392703886719,32.3695095039063],[112.377345,32.3676003242188],[112.361986113281,32.3695095039063],[112.335369902344,32.3538649726563],[112.31388796875,32.3270388007813],[112.235267363281,32.3739479804688],[112.227345,32.3838430000001],[112.231429472656,32.4097585273438],[112.253260527344,32.4179274726563],[112.261429472656,32.4297585273438],[112.288099394531,32.4481716132813],[112.275355253906,32.5050270820313],[112.295921660156,32.5887624335938],[112.267840605469,32.5992702460938],[112.243260527344,32.6272145820313],[112.273260527344,32.6479274726563],[112.281429472656,32.6597585273438],[112.296654082031,32.6702712226563],[112.311429472656,32.7097585273438],[112.32408328125,32.7291896796875],[112.304029570313,32.7430373359375],[112.333260527344,32.7879274726563],[112.337345,32.813843],[112.372625761719,32.8091237617188],[112.382064238281,32.7785622382813],[112.432005644531,32.7669411445313],[112.402760039063,32.7408107734376],[112.401292753906,32.7161721015626],[112.467345,32.703843],[112.473631621094,32.6812697578126],[112.54298953125,32.66948753125],[112.552147246094,32.63659690625],[112.57263796875,32.6396242500001],[112.587345,32.633843],[112.595611601563,32.5835256171876],[112.58298953125,32.53819846875],[112.559954863281,32.500014875],[112.563167753906,32.4782717109376],[112.533558378906,32.4661550117188],[112.522542753906,32.42659690625],[112.493387480469,32.4309059882813],[112.491605253906,32.4188430000001],[112.493167753906,32.4082717109376],[112.471265898438,32.3993093085938],[112.477345,32.3838430000001]]]]}},{"type":"Feature","properties":{"name":"镇平县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[112.231832304688,33.3309841132812],[112.237345,33.323843],[112.224537382813,33.318843],[112.237345,33.313843],[112.24845828125,33.2484206367188],[112.27298953125,33.2294863105469],[112.281783476563,33.2080007148438],[112.317345,33.213843],[112.321429472656,33.1879274726563],[112.345921660156,33.1787624335938],[112.331043730469,33.1181923652344],[112.343260527344,33.1097585273438],[112.351429472656,33.0879274726563],[112.385936308594,33.075014875],[112.4139075,33.0389235664063],[112.39611453125,33.01159690625],[112.417752714844,32.9966579414063],[112.396654082031,32.9402712226562],[112.381073027344,32.9295143867188],[112.385377226563,32.910317609375],[112.330164824219,32.9226955390625],[112.311429472656,32.9097585273438],[112.303260527344,32.8779274726563],[112.297345,32.8738430000001],[112.272122832031,32.8798024726562],[112.223079863281,32.8581081367188],[112.165394316406,32.8495778632813],[112.130582304688,32.8711232734375],[112.111776152344,32.8678835273437],[112.097235136719,32.8874318671875],[112.030999785156,32.8760280585938],[112.033206816406,32.888843],[112.029117460938,32.9125905585938],[112.002345,32.9079811835938],[111.980269804688,32.911782453125],[111.985667753906,32.943139875],[111.977345,32.963843],[112.00681765625,33.0156838203126],[111.991917753906,33.0285182929688],[111.993524199219,33.0485182929688],[111.970738554688,33.068149640625],[111.982772246094,33.0785182929687],[111.981265898438,33.0972866035157],[111.993424101563,33.1303993964844],[111.991165800781,33.1585195136719],[112.00271609375,33.1684706855469],[112.025858183594,33.1953310371094],[112.05271609375,33.2184706855469],[112.064857207031,33.232563703125],[112.0619153125,33.2691933417969],[112.11271609375,33.288470685547],[112.122020292969,33.2992702460938],[112.139522734375,33.2978639960938],[112.147345,33.323843],[112.182713652344,33.3180324531251],[112.201954375,33.3296401191406],[112.212345,33.3281044746094],[112.231832304688,33.3309841132812]]]]}},{"type":"Feature","properties":{"name":"淅川县"},"geometry":{"type":"MultiPolygon","coordinates":[[[[111.441910429688,32.7365407539063],[111.447345,32.7238430000001],[111.424346953125,32.727895734375],[111.441910429688,32.7365407539063]]],[[[111.057345,33.173843],[111.044442167969,33.1503029609375],[111.035030546875,33.1690431953125],[111.057345,33.173843]]],[[[111.023922148438,33.1860353828125],[111.027345,33.173843],[111.015152617188,33.1772658515625],[111.023922148438,33.1860353828125]]],[[[111.147345,33.343843],[111.124620390625,33.3398378730469],[111.141783476563,33.3308461738281],[111.175467558594,33.3389492011719],[111.171656523438,33.3083095527344],[111.232899199219,33.2993959785157],[111.245369902344,33.2838210273438],[111.291265898438,33.2568434882813],[111.312345,33.2594643378906],[111.331890898438,33.2570339179688],[111.350792265625,33.2806349921876],[111.372345,33.2679653144531],[111.392545195313,33.2798378730469],[111.40181765625,33.2682582832031],[111.451790800781,33.2282900214845],[111.482899199219,33.2093959785157],[111.492144804688,33.1978481269532],[111.511986113281,33.2095095039063],[111.522345,33.2082216621095],[111.547906523438,33.2114003730469],[111.568450957031,33.1949489570312],[111.581790800781,33.1782900214844],[111.592899199219,33.1693959785156],[111.597345,33.1538430000001],[111.573372832031,33.133930890625],[111.571834746094,33.118843],[111.572855253906,33.1088430000001],[111.571834746094,33.098843],[111.572855253906,33.088843],[111.571795683594,33.0784523750001],[111.59150515625,33.0620803046875],[111.592894316406,33.048452375],[111.5815246875,33.0390065742188],[111.598800078125,33.008843],[111.577642851563,32.9719020820313],[111.601658964844,32.9519533515625],[111.611883574219,32.9283815742188],[111.622886992188,32.909165265625],[111.620994902344,32.8906081367188],[111.651998320313,32.8682985664062],[111.671561308594,32.8702931953125],[111.735855742188,32.8194069648437],[111.731009550781,32.8669557929688],[111.773463164063,32.9005568671876],[111.787345,32.8838430000001],[111.80068484375,32.83718284375],[111.831241484375,32.8127150703125],[111.837117949219,32.7654689765625],[111.821331816406,32.7386135078126],[111.871790800781,32.7031447578125],[111.860084257813,32.6704274726563],[111.827345,32.6663552070312],[111.802318144531,32.669468],[111.721790800781,32.6593971992187],[111.704610625,32.6379396796875],[111.672799101563,32.6418971992188],[111.637345,32.633843],[111.62170046875,32.62948753125],[111.582323027344,32.6002907539063],[111.577345,32.593843],[111.551610136719,32.5981081367188],[111.543079863281,32.6095778632813],[111.531610136719,32.6181081367188],[111.52048953125,32.6330593085938],[111.523206816406,32.6488430000001],[111.520516386719,32.6644606757813],[111.471610136719,32.6981081367188],[111.459652128906,32.7282009101563],[111.467159453125,32.7718068671876],[111.415523710938,32.7510524726563],[111.373140898438,32.8275075507812],[111.321610136719,32.8381081367188],[111.313079863281,32.8495778632813],[111.291610136719,32.8581081367188],[111.279110136719,32.9042189765625],[111.239959746094,32.8799880195313],[111.244066191406,32.903843],[111.239022246094,32.933139875],[111.247345,32.9538430000001],[111.266634550781,32.9593581367188],[111.261241484375,33.0027150703125],[111.241790800781,33.0182888007813],[111.22935671875,33.0478005195313],[111.151878691406,33.0381618476563],[111.142899199219,33.0514357734376],[111.182899199219,33.0682888007813],[111.191790800781,33.0822731757812],[111.171790800781,33.0982900214844],[111.162899199219,33.1193959785156],[111.138785429688,33.1295571113281],[111.118450957031,33.1549489570313],[111.082691679688,33.1835854316406],[111.057345,33.173843],[111.052296171875,33.193520734375],[111.007767363281,33.2242653632813],[110.987345,33.253843],[110.980418730469,33.2703334785157],[111.001722441406,33.3272670722656],[111.027345,33.3338430000001],[111.045894804688,33.339009015625],[111.063880644531,33.3623110175782],[111.092345,33.3581044746094],[111.102345,33.3595815253906],[111.112857695313,33.3580287910157],[111.1282434375,33.3779628730469],[111.147345,33.343843]]]]}},{"type":"Feature","properties":{"name":"宛城区"},"geometry":{"type":"MultiPolygon","coordinates":[[[[112.637345,32.673843],[112.633922148438,32.6860353828125],[112.625152617188,32.6772658515626],[112.63033328125,32.6636891914063],[112.596927519531,32.6711794257813],[112.587345,32.633843],[112.57263796875,32.6396242500001],[112.552147246094,32.63659690625],[112.54298953125,32.66948753125],[112.473631621094,32.6812697578126],[112.467345,32.703843],[112.49728640625,32.7449611640625],[112.481749296875,32.758843],[112.492940703125,32.7688430000001],[112.4820325,32.7785890937501],[112.484019804688,32.8119362617188],[112.51353640625,32.8383107734375],[112.49162234375,32.8578908515625],[112.502779570313,32.8889870429688],[112.463768339844,32.9238430000001],[112.507906523438,32.9632814765625],[112.522064238281,32.9791237617188],[112.5326575,32.98858909375],[112.530443144531,33.0257546210938],[112.612659941406,33.0385671210938],[112.611947050781,33.0505080390626],[112.635496855469,33.093843],[112.619010039063,33.1241835761719],[112.637345,33.1538430000001],[112.652943144531,33.1602529121094],[112.663053007813,33.1340431953125],[112.697554960938,33.1408608222656],[112.713170195313,33.1296681953125],[112.724920683594,33.1132741523438],[112.770484648438,33.1042702460938],[112.787345,33.1277956367188],[112.797345,33.1138430000001],[112.791429472656,33.1097585273438],[112.770943632813,33.0800905585938],[112.773465605469,33.0688430000001],[112.767789335938,33.0435182929688],[112.787594023438,33.0131032539063],[112.823638945313,32.9996169257813],[112.821224394531,32.988843],[112.824932890625,32.9722951484375],[112.791429472656,32.9597585273438],[112.76978640625,32.921841046875],[112.777345,32.903843],[112.717686796875,32.9112966132813],[112.72525515625,32.8504396796875],[112.661790800781,32.8393971992188],[112.652899199219,32.7682888007813],[112.641666289063,32.7592971015626],[112.643023710938,32.7483888984375],[112.628526640625,32.736782453125],[112.649100371094,32.6832570625],[112.637345,32.673843]]],[[[112.637345,33.1538430000001],[112.627345,33.1538430000001],[112.627345,33.163843],[112.637345,33.163843],[112.637345,33.1538430000001]]]]}},{"type":"Feature","properties":{"name":"卧龙区"},"geometry":{"type":"MultiPolygon","coordinates":[[[[112.525706816406,33.248843],[112.521073027344,33.2281728339844],[112.533260527344,33.2197585273438],[112.541673613281,33.2075722480469],[112.552623320313,33.2100258613282],[112.582847929688,33.1973305488282],[112.600499296875,33.2228932929687],[112.637345,33.213843],[112.633260527344,33.1879274726563],[112.627345,33.163843],[112.627345,33.1538430000001],[112.637345,33.1538430000001],[112.619010039063,33.1241835761719],[112.635496855469,33.093843],[112.611947050781,33.0505080390626],[112.612659941406,33.0385671210938],[112.530443144531,33.0257546210938],[112.5326575,32.98858909375],[112.522064238281,32.9791237617188],[112.507906523438,32.9632814765625],[112.463768339844,32.9238430000001],[112.502779570313,32.8889870429688],[112.49162234375,32.8578908515625],[112.51353640625,32.8383107734375],[112.484019804688,32.8119362617188],[112.4820325,32.7785890937501],[112.492940703125,32.7688430000001],[112.481749296875,32.758843],[112.49728640625,32.7449611640625],[112.467345,32.703843],[112.401292753906,32.7161721015626],[112.402760039063,32.7408107734376],[112.432005644531,32.7669411445313],[112.382064238281,32.7785622382813],[112.372625761719,32.8091237617188],[112.337345,32.813843],[112.333985625,32.8204836250001],[112.315504179688,32.8298342109375],[112.327205839844,32.8537966132813],[112.300704375,32.8672023750001],[112.297345,32.8738430000001],[112.303260527344,32.8779274726563],[112.311429472656,32.9097585273438],[112.330164824219,32.9226955390625],[112.385377226563,32.910317609375],[112.381073027344,32.9295143867188],[112.396654082031,32.9402712226562],[112.417752714844,32.9966579414063],[112.39611453125,33.01159690625],[112.4139075,33.0389235664063],[112.385936308594,33.075014875],[112.351429472656,33.0879274726563],[112.343260527344,33.1097585273438],[112.331043730469,33.1181923652344],[112.345921660156,33.1787624335938],[112.321429472656,33.1879274726563],[112.317345,33.213843],[112.333260527344,33.2179274726563],[112.342345,33.2310842109375],[112.353802519531,33.2144924140625],[112.379176054688,33.2320119453125],[112.394105253906,33.2536330390626],[112.422623320313,33.2600258613282],[112.457647734375,33.2453151679688],[112.483802519531,33.2831935859376],[112.503616972656,33.2695131660156],[112.501051054688,33.2580690742187],[112.525706816406,33.248843]]],[[[112.393922148438,33.2860353828125],[112.397345,33.273843],[112.385152617188,33.2772658515626],[112.393922148438,33.2860353828125]]],[[[112.237345,33.323843],[112.237345,33.313843],[112.224537382813,33.318843],[112.237345,33.323843]]]]}}]});
}));