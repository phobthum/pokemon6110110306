import java.util.Random;
public class Pokemon{
    private String pName;
    private int hp;
    private int chp;
    private int atk;
    private int def;
    private int lv;
    private int exp;
    private int m_xp;

    public Pokemon(String P_name) {
        pName = P_name;
        lv = 1;
        exp = 0;
        m_xp = 30;
        Random r = new Random();
        int iv = r.nextInt(5);
        hp = iv +10;
        atk = iv + 3;
        def = iv + 3;
        chp=hp;
 }
    public String showstatus(){
        return "Name :" + pName +"\nLevel :" + lv +"\nHP :"+ chp +" / "+hp+"\nAttack" + atk +"\nDefend" + def ;
    }
    public int eat(){
        Random r = new Random();
        int i = r.nextInt(3);
        if (i==0){
            hp+=1;
        }
        if (i==1){
            atk+=1;
        }
        if (i==2){
            def+=1;
        }
        return i;
    }
    public void rename(String nname){
        if(nname==""){
            return;
        }
        else
            pName = nname;
    }
    public void lvup(int n){
        lv+=n;
        hp += (5*n) ;
        atk += (5*n);
        def += (5*n);
        m_xp+=(5*n);
    }
    public void heal(){
        chp=hp;
    }
    public String gethp(){
        return chp+"/"+hp;
    }
    public String getname(){
        return pName;
    }
    public int getlv(){
        return lv;
    }
    public int checkhp(){
        return chp;
    }
    public int getmaxhp(){
        return hp;
    }
    public int recivexp(int xp){
        int allxp=xp+exp;
        int i=0;
        while(allxp>m_xp){
            allxp-=m_xp;
            lvup(1);
            i++;
        }
        exp=allxp;
        return i;
    }
    public static void attack(Pokemon pokemon1,Pokemon pokemon2){
        int Damage; 
        if(pokemon2.atk-pokemon1.def<=0)
            Damage = 1;
        else
            Damage = pokemon2.atk-pokemon1.def;
        pokemon1.chp-=Damage;
    }
    
}