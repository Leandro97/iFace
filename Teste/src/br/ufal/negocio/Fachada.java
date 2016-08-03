package br.ufal.negocio;

import java.util.List;

import br.ufal.modelo.Comunidade;
import br.ufal.modelo.ComunidadeUsuario;
import br.ufal.modelo.Usuario;
import br.ufal.persistencia.ComunidadePersistencia;
import br.ufal.persistencia.MensagemPersistencia;
import br.ufal.persistencia.UsuarioPersistencia;

public class Fachada {
	
	private static Fachada instance;
	
	private Fachada() {
		
	}
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	//Bloco de Usu�rio
	
	//persiste um usu�rio no banco
		public void salvarUsuario(Usuario user) {
			UsuarioPersistencia.getInstance().salvarUsuario(user);
		}
	
	//retorna um usu�rio ao receber seu id
		public Usuario getUsuarioById(int id) {
			return UsuarioPersistencia.getInstance().getUsuarioById(id);
		}
	
	//retorna um usu�rio ao receber seu username
		public Usuario getUsuarioByUsername(String username) {
			return UsuarioPersistencia.getInstance().getUsuarioByUsername(username);
		}
	
	//retorna um usu�rio se a combina��o de username e senha estiver cadastrada
		public Usuario login(String username, String senha) {
			return UsuarioPersistencia.getInstance().login(username, senha);
		}
	
	//deleta inst�ncia de usu�rio no banco (Tem que implementar direitinho)
		public void deletarUsuario(Usuario user) {
			UsuarioPersistencia.getInstance().deletarUsuario(user);
		}
		
	//Fim do bloco de Usu�rio
		
	//Bloco de Comunidade
		
	//persiste uma comunidade no banco
		public void salvarComunidade(Comunidade com) {
			ComunidadePersistencia.getInstance().salvarComunidade(com);
		}
		
	//retorna uma comunidade ao receber seu nome
		public Comunidade getComunidadeByNome(String nome) {
			return ComunidadePersistencia.getInstance().getComunidadeByNome(nome);
		}
		
	//retorna um usu�rio ao receber seu id
		public Comunidade getComunidadeById(int id) {
			return ComunidadePersistencia.getInstance().getComunidadeById(id);
		}
		
	//inclui usu�rio em uma comunidade
		public void incluirMembro(Comunidade com, Usuario user) {
			ComunidadePersistencia.getInstance().incluirMembro(com, user, false);
		}	
	//retorna lista de usu�rios que ainda n�o foram aceitos em uma comunidade	
		public List<ComunidadeUsuario> getMembrosPendentes(Comunidade com) {
			return ComunidadePersistencia.getInstance().getMembrosPendentes(com);
		}
		
	//Fim do bloco de Comunidade
		
	//Bloco de Mensagem

	//envia mensagens de usu�rio para usu�rio
		public void mensagemParaComunidade(Usuario emissor, Comunidade receptor, String conteudo) {
			MensagemPersistencia.getInstance().mensagemParaComunidade(emissor, receptor, conteudo);
		}		
		
	//envia mensagens de usu�rio para usu�rio
		public void mensagemParaUsuario(Usuario emissor, Usuario receptor, String conteudo) {
			MensagemPersistencia.getInstance().mensagemParaUsuario(emissor, receptor, conteudo);
		}
	//Fim do bloco de Mensagem	
		
}
