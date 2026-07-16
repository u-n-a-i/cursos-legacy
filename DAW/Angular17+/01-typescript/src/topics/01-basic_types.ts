//* Tipos básicos

const name: string = "mi nombre";
const age: number = 99;

let ticket: number | string = 45;
ticket = "45";

const isAlive: boolean = true;

console.log({
  name,
  ticket,
  isAlive,
});

export {};
