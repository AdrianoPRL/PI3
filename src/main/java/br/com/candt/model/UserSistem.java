package br.com.candt.model;

import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UserSistem {

    private String nomeCompleto;
    private String usuario;
    private String hashSenha;
    private String tipoDeUser;

    public UserSistem() {

    }

    public UserSistem(String nomeCompleto, String hashSenha, String usuario, String tipoDeUser) {
        this.nomeCompleto = nomeCompleto;
        this.usuario = usuario;
        setHashSenha(hashSenha);
        this.tipoDeUser = tipoDeUser;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public boolean verificarSenha(String senhaAberta) {
        return BCrypt.checkpw(senhaAberta, hashSenha);
    }

    public String getTipoDeUser() {
        return tipoDeUser;
    }

    public void setTipoDeUser(String tipoDeUser) {
        this.tipoDeUser = tipoDeUser;
    }

}
