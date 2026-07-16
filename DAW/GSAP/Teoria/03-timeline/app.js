// gsap.from("#box1",{
//     opacity:0,
//     duration:2,
//     x:300
// })
// gsap.from("#box2",{
//     opacity:0,
//     duration:2,
//     delay:2,
//     x:300
// })

const tl =gsap.timeline({repeat: 1, repeatDelay: 1});

tl.from("#box1",{
    opacity:0,
    duration:2,
    x:300
})
tl.from("#box2",{
    opacity:0,
    duration:2,
    x:300
})
tl.from(
    "#demo",{
        opacity:0
    },3
)
tl.from("#box3",{
    opacity:0,
    duration:2,
    x:300
})