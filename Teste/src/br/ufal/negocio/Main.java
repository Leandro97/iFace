package br.ufal.negocio;

import java.util.List;

import br.ufal.modelo.Usuario;

public class Main {
	public static void main(String[] args) {
		
//		Usuario u1 = new Usuario("emissor", "emissor", "emissor");
//		Usuario u2 = new Usuario("emissor2", "emissor2", "emissor2");
//		Usuario u3 = new Usuario("emissor3", "emissor3", "emissor3");
//		Usuario ur = new Usuario("dono", "dono", "dono");
//		Usuario um = new Usuario("Leandro", "Droogie123", "senha123");
//		
//		Fachada.getInstance().salvarUsuario(u1);
//		Fachada.getInstance().salvarUsuario(u2);
//		Fachada.getInstance().salvarUsuario(u3);
//		Fachada.getInstance().salvarUsuario(ur);
//		Fachada.getInstance().salvarUsuario(um);
//		
//		Fachada.getInstance().enviarPedidoDeAmizade(Fachada.getInstance().getUsuarioByUsername("emissor"), Fachada.getInstance().getUsuarioByUsername("emissor2"), false);
//		Fachada.getInstance().enviarPedidoDeAmizade(Fachada.getInstance().getUsuarioByUsername("emissor3"), Fachada.getInstance().getUsuarioByUsername("emissor2"), false);
//		Fachada.getInstance().enviarPedidoDeAmizade(Fachada.getInstance().getUsuarioByUsername("dono"), Fachada.getInstance().getUsuarioByUsername("emissor2"), false);
//		Fachada.getInstance().enviarPedidoDeAmizade(Fachada.getInstance().getUsuarioByUsername("Droogie123"), Fachada.getInstance().getUsuarioByUsername("emissor2"), false);
//		Fachada.getInstance().enviarPedidoDeAmizade(Fachada.getInstance().getUsuarioByUsername("emissor2"), Fachada.getInstance().getUsuarioByUsername("emissor"), false);
//		
//		List<Amizade> amizades = Fachada.getInstance().getPedidosPendentes(Fachada.getInstance().getUsuarioByUsername("emissor2"));
//		
//		for(Amizade am : amizades) {
//			System.out.println(am.getSolicitado().getNome() + ". " + am.getSolicitante().getNome());
//		}
//		
//		Fachada.getInstance().aceitarPedidos(amizades.get(0));
//		
//		System.out.println("---");
//		
//		amizades = Fachada.getInstance().getPedidosPendentes(Fachada.getInstance().getUsuarioByUsername("emissor2"));
//		
//		for(Amizade am : amizades) {
//			System.out.println(am.getSolicitado().getNome() + ". " + am.getSolicitante().getNome());
//		}
//
		List<Usuario> amigos =  Fachada.getInstance().getAmigos(Fachada.getInstance().getUsuarioByUsername("emissor"));
		for(Usuario user : amigos) {
			System.out.println(user.getNome());
		}
//			
//		Comunidade com = new Comunidade("Teste 1", "Teste 1 bem massa", Fachada.getInstance().getUsuarioByUsername("dono"));
//		Fachada.getInstance().salvarComunidade(com);
//		
//		Fachada.getInstance().incluirMembro(Fachada.getInstance().getComunidadeByNome("Teste 1"), Fachada.getInstance().getUsuarioByUsername("emissor"));		
//		Fachada.getInstance().incluirMembro(Fachada.getInstance().getComunidadeByNome("Teste 1"), Fachada.getInstance().getUsuarioByUsername("emissor2"));	
//	
//		Fachada.getInstance().mensagemParaUsuario(Fachada.getInstance().getUsuarioByUsername("emissor3"), Fachada.getInstance().getUsuarioByUsername("emissor"), "Usu�rio para Usu�rio");
//	
//		Fachada.getInstance().mensagemParaComunidade(Fachada.getInstance().getUsuarioByUsername("emissor"), Fachada.getInstance().getComunidadeByNome("Teste 1"), "Usu�rio para Comunidade");
//		
//		Comunidade com2 = new Comunidade("Teste 2", "Teste 2 bem massa", Fachada.getInstance().getUsuarioByUsername("emissor2"));
//		Fachada.getInstance().salvarComunidade(com2);
//		
//		Fachada.getInstance().incluirMembro(Fachada.getInstance().getComunidadeByNome("Teste 2"), Fachada.getInstance().getUsuarioByUsername("emissor3"));		
//		Fachada.getInstance().incluirMembro(Fachada.getInstance().getComunidadeByNome("Teste 2"), Fachada.getInstance().getUsuarioByUsername("Droogie123"));	
//	
//		List<ComunidadeUsuario> pendencias = Fachada.getInstance().getMembrosPendentes(Fachada.getInstance().getComunidadeByNome("Teste 1"));
//		
//		for(ComunidadeUsuario cu : pendencias) {
//			System.out.println(cu.getComunidade().getNome() + ": " + cu.getParticipante().getNome());
//		}
//		
		
//		Banco.getInstance().deletarUsuario(Banco.getInstance().getUsuariobyUsername("emissor3"));
		}
}
