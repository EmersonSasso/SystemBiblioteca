/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.List;

/**
 *
 * @author Hemerson Mendes
 */
public class Constantes {

    private final static String version = "Biblioteca 1.0", pass = "eC2vgJPvHou43n6P_RoriGtY_VtkJvUU"
            , user = "yubdrxpi", driver = "org.postgresql.Driver";
    private static String host, servico, portNumber;//, usuario, name;
    private static boolean conectou = false;
    private static Main main;
    private static Metodos_Comum met;
    private static Metodos_Banco_Post mbd;
    private static VwUsuario vwusuario;
    private static VwUsuario vwusuarioLogado;
    private static TGenero tg;    
    private static VwLivro vwlivro;
    private static Json json;
    private static List<TGenero> Lgenero;
    private static Metodos_Genero mg;
    private static Metodos_Usuario mu;
    private static Metodos_Livro ml;
    private static List<VwUsuario> Lusuario;
    private static List<VwLivro> Llivro;
    private static CallAPI ca;
    private static Metodos_Importacao mi;

    public static String getVersion() {
        return version;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String aHost) {
        host = aHost;
    }

    public static String getServico() {
        return servico;
    }

    public static void setServico(String aServico) {
        servico = aServico;
    }

    public static String getPortNumber() {
        return portNumber;
    }

    public static void setPortNumber(String aPortNumber) {
        portNumber = aPortNumber;
    }

    public static String getPass() {
        return pass;
    }

    public static String getUser() {
        return user;
    }

    public static boolean isConectou() {
        return conectou;
    }

    public static void setConectou(boolean aConectou) {
        conectou = aConectou;
    }

    public static String getDriver() {
        return driver;
    }

    public static Metodos_Comum getMet() {
        return met;
    }

    public static void setMet(Metodos_Comum aMet) {
        met = aMet;
    }

    public static Metodos_Banco_Post getMbd() {
        return mbd;
    }

    public static void setMbd(Metodos_Banco_Post aMbd) {
        mbd = aMbd;
    }

    public static VwUsuario getVwusuario() {
        return vwusuario;
    }

    public static void setVwusuario(VwUsuario aVwusuario) {
        vwusuario = aVwusuario;
    }

    public static VwLivro getVwlivro() {
        return vwlivro;
    }

    public static void setVwlivro(VwLivro aVwlivro) {
        vwlivro = aVwlivro;
    }

    public static Json getJson() {
        return json;
    }

    public static void setJson(Json aJson) {
        json = aJson;
    }

    public static Metodos_Genero getMg() {
        return mg;
    }

    public static void setMg(Metodos_Genero aMg) {
        mg = aMg;
    }

    public static Main getMain() {
        return main;
    }

    public static void setMain(Main aMain) {
        main = aMain;
    }   

    public static Metodos_Usuario getMu() {
        return mu;
    }

    public static void setMu(Metodos_Usuario aMu) {
        mu = aMu;
    }

    public static List<VwUsuario> getLusuario() {
        return Lusuario;
    }

    public static void setLusuario(List<VwUsuario> aLusuario) {
        Lusuario = aLusuario;
    }

    public static CallAPI getCa() {
        return ca;
    }

    public static void setCa(CallAPI aCa) {
        ca = aCa;
    }

    public static List<VwLivro> getLlivro() {
        return Llivro;
    }

    public static void setLlivro(List<VwLivro> aLlivro) {
        Llivro = aLlivro;
    }

    public static Metodos_Livro getMl() {
        return ml;
    }

    public static void setMl(Metodos_Livro aMl) {
        ml = aMl;
    }

    public static List<TGenero> getLgenero() {
        return Lgenero;
    }

    public static void setLgenero(List<TGenero> aLgenero) {
        Lgenero = aLgenero;
    }

    public static TGenero getTg() {
        return tg;
    }

    public static void setTg(TGenero aTg) {
        tg = aTg;
    }

    public static VwUsuario getVwusuarioLogado() {
        return vwusuarioLogado;
    }

    public static void setVwusuarioLogado(VwUsuario aVwusuarioLogado) {
        vwusuarioLogado = aVwusuarioLogado;
    }

    public static Metodos_Importacao getMi() {
        return mi;
    }

    public static void setMi(Metodos_Importacao aMi) {
        mi = aMi;
    }

}
