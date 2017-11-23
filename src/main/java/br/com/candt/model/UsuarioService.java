
package br.com.candt.model;



public class UsuarioService {



  public boolean usuarioAutorizado(UserSistem usuario,
	  String funcionalidade) {
      String a=usuario.getTipoDeUser();
    if ("/home".equalsIgnoreCase(funcionalidade)
	    &&a.equalsIgnoreCase("funcionario") ) {
        
      return true;
    } else if ("/selecionarCliente".equalsIgnoreCase(funcionalidade)
	    && a.equalsIgnoreCase("ADMIN")) {
      return true;
    }
    return false;
  }
}
