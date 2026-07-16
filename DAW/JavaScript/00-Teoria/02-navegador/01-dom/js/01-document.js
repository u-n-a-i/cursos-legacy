// Documento

let elemento;

elemento = document;
elemento = document.head;
elemento = document.body;
elemento = document.URL;
elemento = document.characterSet;
elemento = document.contentType;

elemento = document.forms;
elemento = document.forms[0];
elemento = document.forms[0].id;
elemento = document.forms[0].method;
elemento = document.forms[0].action;

elemento = document.links;
elemento = document.links[3].id;
elemento = document.links[3].className;

elemento = document.images;
elemento = document.images[0];
elemento = document.images[0].id;

elemento = document.scripts;
elemento = document.scripts[0].getAttribute("src");
elemento = document.scripts[1].getAttribute("src");

console.log(elemento);
