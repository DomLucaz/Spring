package br.org.generation.personalBlog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_temas")
public class Theme{
	    
	    @Id	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull(message = "O atributo Descrição deve ser obrigatório")
		private String descricao;

		@OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("theme")
		private List<Post> post;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public List<Post> getPost() {
			return post;
		}

		public void setPost(List<Post> post) {
			this.post = post;
		}
		
		
}