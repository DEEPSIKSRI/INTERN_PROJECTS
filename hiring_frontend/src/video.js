import { BlazeFaceModel } from "@tensorflow-models/blazeface";

let video=document.getElementById("video");
const setUpCamera =() =>
{
  navigator.mediaDevices.getUserMedia({
    video:{width:600,height:400},
    audio:false,
  }).then(stream =>
    {
      video.srcObject = stream;
    });
};
const deductFace = async ()=>
{
    const prediction=await model.estimatFaces(video,false);
    console.log(prediction);
};
setUpCamera();
video.addEventListener("LoadedData",async ()=>
{
model=await blazeface.load();
deductFace();
})
    
