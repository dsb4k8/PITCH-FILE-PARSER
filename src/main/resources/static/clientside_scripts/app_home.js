/**
 * 
 */

const tl = gsap.timeline({defaults: {ease: 'power1.out'}});

tl.to(".text", {y:"0%", duration: 1, stagger: 0.25});
tl.to('.slider', {y:"-100%", duration: 2, delay:0.5});
tl.to('.intro',{y: "-100%", duration: 1}, "-=2");
tl.fromTo('nav', {opacity: 0}, {opacity:1, duration:1});
tl.fromTo('.big-text', {opacity: 0}, {opacity:1, duration:1}, "-=1"),
tl.fromTo('form', {opacity: 0}, {opacity:1, duration:0.5});
