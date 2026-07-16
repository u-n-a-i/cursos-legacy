gsap.to("#page2 h1",{
    transform:"translateX(-150%)",
    scrollTrigger:{
        trigger:"#page2",
        scroller:"body",
        scrub:2,
        pin:true
    }
})