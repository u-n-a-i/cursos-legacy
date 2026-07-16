gsap.registerPlugin(MorphSVGPlugin);

const path = document.getElementById("morph_path");

const shapes = [
   "M50,10 A40,40 0 1,1 49.9,10 Z",//Circle
   "M50,10 L61,35 L88,38 L66,58 L72,85 L50,70 L28,85 L34,58 L12,38 L39,35 Z", // Star
   "M50,30 C50,15 70,15 70,30 C70,45 50,60 50,60 C50,60 30,45 30,30 C30,15 50,15 50,30 Z" // Heart
];


let index = 0;

function morphShape() {
    const nextShape = shapes[(index + 1) % shapes.length];
    gsap.to(path,{
        duration:2,
        morphSVG:nextShape,
        ease: "power1.inOut",
        onComplete : () => {
            index = (index +1) % shapes.length;
            morphShape();
        }
    })
}

morphShape();
