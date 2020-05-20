var firebase = require("firebase/app");
require("firebase/auth");
require("firebase/firestore");
const prompt = require('prompt-sync')();




var config = {
  apiKey: "AIzaSyD3rsmWJbsBPTwj9jpXG_Bkf1g-ELZG3oA",
  authDomain: "lab2psr.firebaseapp.com",
  databaseURL: "https://lab2psr.firebaseio.com",
  projectId: "lab2psr",
  storageBucket: "lab2psr.appspot.com",
  messagingSenderId: "946702323408",
  appId: "1:946702323408:web:6d56484905e03bd7a798d5",
  measurementId: "G-NN2W7LETHH"
};

var defaultProject = firebase.initializeApp(config);
var firestore = defaultProject.firestore();
var docRef = firestore.collection("Przychodnia").doc("wiz");

createMenu = () => {
  console.log('**************  MENU:  ***************');
  console.log('1 - Dodaj nowa wizytę ');
  console.log('2 - Wyświetl wszystkie wizyty ');
  console.log('3 - Wyświetl wizytę po jego id ');
  console.log('4 - Zaktualizuj wizytę ');
  console.log('5 - Usuń wizytę ');
  console.log('6 - Wyświetl wszystkie wizyty danego lekarza ');
  console.log('0 - WYJŚCIE');
};

function addWizyta(idWizyta, data, imieP, nazwiskoP, nazwaL) {

  let object = {
    company: "101",
    ['Wizyta']: {
      idWizyta: idWizyta,
      data: data,
      imiePacjenta: imieP,
      nazwiskoPacjenta: nazwiskoP,
      nazwaLekarza: nazwaL,
    }
  };

  let colRef= firestore.collection("Przychodnia");
  colRef.add(object);
};

function sawAll() {
  let getRef = firestore.collection("Przychodnia").where('company','==',"101").get().then(result =>{
    result.docs.forEach(doc=>{
      console.log(doc.data().Wizyta);
    })
  })
};

function getOneById(idWizyta){
  let getRef = firestore.collection("Przychodnia").where('company','==',"101").get().then(result =>{
    result.docs.forEach(doc=>{
      if(doc.data().Wizyta.idWizyta == idWizyta){
        console.log(doc.data().Wizyta);
      }
    })
  })
};

function update(idWizyta, data, imieP, nazwiskoP, nazwaL){
  let object = {
    company: "101",
    ['Wizyta']: {
      idWizyta: idWizyta,
      data: data,
      imiePacjenta: imieP,
      nazwiskoPacjenta: nazwiskoP,
      nazwaLekarza: nazwaL,
    }
  };

   firestore.collection("Przychodnia").where('company','==',"101").get().then(result =>{
    result.docs.forEach(doc=>{
      if(doc.data().Wizyta.idWizyta == idWizyta){
        firestore.collection("Przychodnia").doc(doc.id).set(object);
      }
    })
  })
}

function deleteId(idWizyta){
  let getRef = firestore.collection("Przychodnia").where('company','==',"101").get().then(result =>{
    result.docs.forEach(doc=>{
      if(doc.data().Wizyta.idWizyta == idWizyta){
        firestore.collection("Przychodnia").doc(doc.id).delete();
      }
    })
  })
}

function getAllLekarz(nazwaL){
  let getRef = firestore.collection("Przychodnia").where('company','==',"101").get().then(result =>{
    result.docs.forEach(doc=>{
      if(doc.data().Wizyta.nazwaL == nazwaL){
        console.log(doc.data().Wizyta);
      }
    })
  })
}


fillData = () => {
  addWizyta(1, "2020-05-20", "Jacek", "Mak", "dentysta");
  addWizyta(2, "2020-05-10", "Alicja", "Kij", "ortopeda");
  addWizyta(3, "2020-05-2", "Marek", "Ogórek", "chirurg");
  addWizyta(4, "2020-05-6", "Aleksandra", "Ban", "dentysta");
};


action = (number) => {
  switch (parseInt(number)) {
    case 1:
      const id = prompt('Podaj id wizyty: ');
      const data = prompt('Podaj date: ');
      const imieP = prompt('Podaj imie pacjenta: ');
      const nazwiskoP = prompt('Podaj nazwisko pacjenta: ');
      const nazwaL = prompt('Podaj nazwe lekarza: ');
      addWizyta(id, data, imieP, nazwiskoP, nazwaL);
      break;
    case 2:
      sawAll();
      break;
    case 3:
      const idw = prompt('Podaj id wizyty: ');
      getOneById(idw);
      break;
    case 4:
      const idu = prompt('Podaj id wizyty: ');
      getOneById(idu);
      const idn = prompt('Podaj nowe id wizyty: ');
      const datan = prompt('Podaj nową date: ');
      const imiePn = prompt('Podaj nowe imie pacjenta: ');
      const nazwiskoPn = prompt('Podaj nowe nazwisko pacjenta: ');
      const nazwaLn = prompt('Podaj nową nazwe lekarza: ');
      update(idn,datan,imiePn,nazwiskoPn,nazwaLn);
      break;
    case 5:
      const idd = prompt('Podaj id wizyty: ');
      deleteId(idd);
      break;
    case 6:
      const nazwaLd = prompt('Podaj nazwe lekarza: ');
      getAllLekarz(nazwaLd);
      break;
    case 0:
      choose = false;
      console.log('Konczymy program');
      stopScript();
      break;
  }
};

//fillData();
createMenu();

const number = prompt('Twoj wybor to: ');
action(number);