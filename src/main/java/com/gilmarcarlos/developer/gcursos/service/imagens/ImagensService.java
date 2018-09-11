package com.gilmarcarlos.developer.gcursos.service.imagens;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilmarcarlos.developer.gcursos.model.images.Imagens;
import com.gilmarcarlos.developer.gcursos.model.images.ImagensEventoOnlineDestaque;
import com.gilmarcarlos.developer.gcursos.model.images.ImagensEventoOnlineTop;
import com.gilmarcarlos.developer.gcursos.model.images.ImagensEventoPresencialDestaque;
import com.gilmarcarlos.developer.gcursos.model.images.ImagensEventoPresencialTop;
import com.gilmarcarlos.developer.gcursos.model.images.ImagensLogoListaPresenca;
import com.gilmarcarlos.developer.gcursos.repository.eventos.online.ImagensEventoOnlineDestaqueRepository;
import com.gilmarcarlos.developer.gcursos.repository.eventos.online.ImagensEventoOnlineTopRepository;
import com.gilmarcarlos.developer.gcursos.repository.eventos.presencial.ImagensEventoPresencialDestaqueRepository;
import com.gilmarcarlos.developer.gcursos.repository.eventos.presencial.ImagensEventoPresencialTopRepository;
import com.gilmarcarlos.developer.gcursos.repository.eventos.presencial.ImagensLogoListaPresencaRepository;
import com.gilmarcarlos.developer.gcursos.repository.usuarios.ImagensRepository;

@Service
public class ImagensService {

	@Autowired
	private ImagensRepository repository;
	
	@Autowired
	private ImagensEventoPresencialTopRepository repositoryImagensEvePresTop;
	
	@Autowired
	private ImagensEventoOnlineTopRepository repositoryImagensEveOnlineTop;
	
	@Autowired
	private ImagensEventoOnlineDestaqueRepository repositoryImagensEveOnlineDestaque;
	
	@Autowired
	private ImagensEventoPresencialDestaqueRepository repositoryImagensEvePresDestaque;
	
	@Autowired
	private ImagensLogoListaPresencaRepository repositoryImagensLogoListaPresenca;
	
	public Imagens salvar(Imagens imagens) {
		return repository.save(imagens);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
	public Imagens buscarPor(Long id) {
		return repository.buscarPor(id);
	}
	
	public BufferedImage verifica(BufferedImage imagem, Integer altura, Integer largura) {
		
		if(imagem.getHeight() > altura || imagem.getWidth() > largura) {
			imagem = redimensionar(imagem, largura, altura);
		}
		
		if(imagem.getHeight() < altura || imagem.getWidth() < largura) {
			imagem = redimensionar(imagem, largura, altura);
		}
		
		return imagem;
	}

	private BufferedImage redimensionar(BufferedImage imagem, Integer largura, Integer altura) {
		Image tmp = imagem.getScaledInstance(largura, altura, Image.SCALE_DEFAULT); // .SCALE_SMOOTH);
		imagem = new BufferedImage(largura, altura, BufferedImage.SCALE_DEFAULT); // .TYPE_INT_ARGB);
		Graphics2D g2d = imagem.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return imagem;
	}

	public void deletarImagemEvePreTop(Long id) {
		repositoryImagensEvePresTop.deleteById(id);
	}
	
	public ImagensEventoPresencialTop salvarImagemEvePresTop(ImagensEventoPresencialTop imagens){
			return repositoryImagensEvePresTop.save(imagens);
	}

	public void deletarImagemEvePreDestaque(Long id) {
		repositoryImagensEvePresDestaque.deleteById(id);
	}
	

	public ImagensEventoPresencialDestaque salvarImagemEvePresDestaque(ImagensEventoPresencialDestaque imagens) {
		return repositoryImagensEvePresDestaque.save(imagens);
	}
	
	public void deletarImagemLogListaPresenca(Long id) {
		repositoryImagensLogoListaPresenca.deleteById(id);
	}

	public ImagensLogoListaPresenca salvarImagemLogListaPresenca(ImagensLogoListaPresenca imagens) {
		return repositoryImagensLogoListaPresenca.save(imagens);
	}
	
	public void deletarImagemEveOnlineTop(Long id) {
		repositoryImagensEveOnlineTop.deleteById(id);
	}
	
	public ImagensEventoOnlineTop salvarImagemEveOnlineTop(ImagensEventoOnlineTop imagens){
		return repositoryImagensEveOnlineTop.save(imagens);
	}
	
	public void deletarImagemEveOnlineDestaque(Long id) {
		repositoryImagensEveOnlineDestaque.deleteById(id);
	}
	
	public ImagensEventoOnlineDestaque salvarImagemEveOnlineDestaque(ImagensEventoOnlineDestaque imagens) {
		return repositoryImagensEveOnlineDestaque.save(imagens);
	}
}	
