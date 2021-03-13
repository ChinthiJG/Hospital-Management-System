
package GetSet;


public class WardDAO {
    
    String wardno;
    String wardtype;
    //String wardname;
    //String docId;
    
    public WardDAO(String wardno,String wardtype){
        this.wardno=wardno;
        this.wardtype=wardtype;
        //this.wardname=wardname;
        //this.docId=docId;
    }
    
    public WardDAO(){
        
    }

    public String getWardno() {
        return wardno;
    }

    public void setWardno(String wardno) {
        this.wardno = wardno;
    }

    public String getWardtype() {
        return wardtype;
    }

    public void setWardtype(String wardtype) {
        this.wardtype = wardtype;
    }

//    public String getWardname() {
//        return wardname;
//    }
//
//    public void setWardname(String wardname) {
//        this.wardname = wardname;
//    }

   
    
}
