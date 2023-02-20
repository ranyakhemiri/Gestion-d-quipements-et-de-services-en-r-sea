public class Equipement {
    private int id ;
    private String name;
    private String address; 
    private String service;

    //pour des raisons de sécurité, on laisse les attributs "private"
    // et on crée des getteurs et setteurs 
    // qu'on utilisera dans l'implémentation (classe EquImpl)
    

    // constructeur 
    public Equipement(int id, String name, String ad, String s){
        this.id = id; 
        this.name = name ;
        this.address = ad;
        this.service = s;
    }
    
    
    // ******* getters *******
    public String getName(){
        return this.name;
    }

    public String getService(){
        return this.service;
    }

    public String getAddress(){
        return this.address;
    }

    public int getId(){
        return this.id;
    }


    // ******* setters *******

    // on suppose qu'on peut pas changer l'id 
    // une fois que l'objet a été créé
    public void setName(String name ){
        this.name = name;
    }

    public void setAddress(String ad ){
        this.address = ad;
    }

    public void setService(String s ){
        this.service = s;
    }
}
