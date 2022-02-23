
package Lecture3;

/**
 *
 * @author ALPARSLAN
 */
public class Lecture3 {
    musteri bas,son;

    public Lecture3() {
        bas=null;
        son=null;
    }
    
    //bağli liste basa ekleme
    void basaEkle(musteri yeni){
        if(son==null){
            bas=yeni;
            son=yeni;
        }else{
            yeni.ileri=bas;
            bas=yeni;
        }
    }
    
    //bagli liste sona Ekleme
    void sonaEkle(musteri yeni){
        if(bas == null){
            son=yeni;
            bas=yeni;
        }else{
            son.ileri =yeni;
            son=yeni;
        }
    }
    
    //bagli liste sirali ekleme
    void siraliEkle(musteri yeni){
        if(bas==null || bas.id >= yeni.id){
            yeni.ileri=bas;
            bas=yeni;
            return;
        }
        musteri tmp =bas;
        while(tmp.ileri != null && tmp.ileri.id <yeni.id){
            tmp=tmp.ileri;
        }
        yeni.ileri =tmp.ileri;
        tmp.ileri =yeni;
    }
    
    //bagli listenin basindan silme işlemi
    musteri bastanSil(){
        musteri silinen =bas;
        bas=bas.ileri;
        if(bas == null){
            son=null;
            return null;
        }
        return silinen;
    }
    
    //bagli listenin sonundan silme işlemi
    void listesonuSil(){
        musteri tmp = bas, once =null;
        
        while(tmp.ileri !=null){
            once=tmp;
            tmp=tmp.ileri;
        }
        
        if(once ==null){
            bas=null;
        }else{
            once.ileri =null;
        }
        son=once;
    }
    
    
    
}
class musteri{
    int id;
    String isim;
    double borc;
    musteri ileri;

    public musteri(int id,String isim,double borc) {
        this.id=id;
        this.isim=isim;
        this.borc=borc;
        ileri=null;
    }
    
}