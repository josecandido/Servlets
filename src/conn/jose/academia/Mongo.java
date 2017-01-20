package conn.jose.academia;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class Mongo {
	
	public MongoClient mongo;

	 private void crearConexion() {
	       this.mongo = null;
	        try {
	        	System.out.println("Conectando a Mongodb");
	        	 this.mongo = new MongoClient("localhost", 27017);
	        	
	        }
	        catch(Exception e){
	        	System.out.println("no funciona");
	        }
	       
	    }
	 @SuppressWarnings("unused")
	private String printDatabases() {
		 	StringBuilder databases=new StringBuilder();
		 	DB db= mongo.getDB( "amazon" );
		 	DBCollection coll = db.getCollection("blackfriday");
			DBCursor cursor = coll.find();
		 	try {
		 	   while(cursor.hasNext()) {
		 	      databases.append(cursor.next());
		 		  //databases.append(cursor.curr().get("nombre"));
		 	      databases.append("<br>");
		 	     //cursor.next();		 	      
		 	   }
		 	}
		 	finally {
		 	   cursor.close();
		 	}
			return databases.toString();
	    }
	 
	 public String toString(){
		 	StringBuilder db = new StringBuilder();
		 	MongoClient mongoClient = new MongoClient("localhost");
			MongoDatabase database = mongoClient.getDatabase("amazon");
			MongoCollection<Document> collection = database.getCollection("blackfriday");
			MongoCursor<Document> cursor = collection.find().iterator();
			
			try 
			{
				db.append("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");

				db.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>");

				db.append("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
				db.append("<title>Listado de Productos</title></head><body><table class='table table-striped'><tr><th>Referencia</th><th>Nombre</th><th>Unidades</th><th>Precio</th><th>Fecha</th></tr>");
			    while (cursor.hasNext()) 
			    {
			    	Document d=cursor.next();
			    	db.append("<tr><td>"+d.get("id")+"</td><td>"+d.get("nombre")+"</td><td>"+d.get("unidades")+"</td><td>"+d.get("precio")+"</td><td>"+d.get("fecha")+"</td></tr>");
			    }
			    db.append("</table><a href='./index.jsp' class='btn btn-default'>Inicio</a></body></html>");

			} 
			finally 
			{
			    cursor.close();
			}
		 return db.toString();
		 
	 }
	 public void insertar(String id,String nombre,String precio,String unidades, String fecha){
		 try {

					this.crearConexion();
				 	DB db= mongo.getDB( "amazon" );
				 	DBCollection coll = db.getCollection("blackfriday");
				 	StringBuilder dbs = new StringBuilder();

					BasicDBObject doc = new BasicDBObject("id", id).append("nombre", nombre)
							.append("unidades",unidades).append("precio",precio).append("fecha",fecha);
					

					coll.insert(doc);
					dbs.append("<html><head></head><body><h2>Producto Insertado</p></body></html>");
					   
					

				} catch (Exception e) {
					System.err.println(e.getClass().getName() + ": " + e.getMessage());
					
				}
	 }
			
		 public void eliminar(String id){
			 try {

						this.crearConexion();
					 	DB db= mongo.getDB( "amazon" );
					 	DBCollection coll = db.getCollection("blackfriday");
					 	StringBuilder dbs = new StringBuilder();
					 	
					 	BasicDBObject doc = new BasicDBObject("id", id);

						coll.remove(doc);
						dbs.append("<html><head></head><body><h2>Producto Eliminado</p></body></html>");
						

					} catch (Exception e) {
						System.err.println(e.getClass().getName() + ": " + e.getMessage());
						
					}
		 }
			 
			 public void modificar(String nombre, String nuevonombre){
				 try {

							this.crearConexion();
						 	DB db= mongo.getDB( "amazon" );
						 	DBCollection coll = db.getCollection("blackfriday");
						 	StringBuilder dbs = new StringBuilder();
						 	
						 	BasicDBObject doc = new BasicDBObject();
						 	doc.append("$set", new BasicDBObject().append("nombre", nuevonombre));

						 	BasicDBObject searchQuery = new BasicDBObject().append("nombre", nombre);

						 	coll.update(searchQuery, doc);
						 	
							dbs.append("<html><head></head><body><h2>Producto Modificado</p></body></html>");
							

						} catch (Exception e) {
							System.err.println(e.getClass().getName() + ": " + e.getMessage());
							
						}
				 
		 
	 }

	

}
