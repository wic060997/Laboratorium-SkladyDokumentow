var dbHost = "127.0.0.1";
var dbPort = 5984;
var dbName = 'biuropodrozy';
var couchdb = require('felix-couchdb');
var client = couchdb.createClient(dbPort,dbHost, 'admin','admin',0,true);
var db = client.db(dbName);

db.getDoc('2609',function(err,doc)){
  console.log(doc);
}