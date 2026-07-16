// function addNumbers(a: number, b: number): number {
//   return a + b;
// }

// console.log(addNumbers(4, 10));

// function multiply(
//   firstNumber: number,
//   secondNumber?: number,
//   base: number = 2
// ) {
//   return firstNumber * base;
// }

// console.log(multiply(5));

//* Flecha
// const addNumbersArrow = (a: number, b: number): string => {
//   return `${a} + ${b}`;
// };

// console.log(addNumbersArrow(4, 3));

// export {};

// *Funciones con objetos como argumentos
interface Character {
  name: string;
  hp: number;
  showHp: () => void;
}
const healCharacter = (character: Character, amount: number) => {
  character.hp += amount;
};

const strider: Character = {
  name: "Strider",
  hp: 50,
  showHp() {
    console.log(`Puntos de vida ${this.hp}`);
  },
};

healCharacter(strider, 10);
healCharacter(strider, 40);

strider.showHp();
