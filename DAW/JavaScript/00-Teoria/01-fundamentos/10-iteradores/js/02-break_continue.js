// Break
for (let i = 0; i <= 10; i++) {
  if (i === 5) {
    console.log("Estamos en el 5... FIN.");
    break;
  }
  console.log(`Numero:  ${i} `);
}

// Continue
for (let i = 0; i <= 10; i++) {
  if (i === 5) {
    console.log("Estamos en el 5... CONTINUAR....");
    continue;
  }
  console.log(`Numero:  ${i} `);
}
