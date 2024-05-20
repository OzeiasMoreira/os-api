package com.ozeias.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ozeias.os.services.DBService;

@Configuration // Esta anotação indica que esta classe é uma classe de configuração do Spring.
@Profile("dev") // Esta anotação indica que esta classe de configuração deve ser usada apenas
				// quando o perfil ativo do aplicativo for "dev".
public class DevConfig {

	@Autowired
	private DBService dbService; // Esta linha injeta por meio de autowiring uma instância da classe DBService.

	@Value("${spring.jpa.hibernate.ddl-auto}") /*
												 * Este é um exemplo de uso da anotação @Value para injetar valores de
												 * propriedades do arquivo de configuração (application.properties ou
												 * application.yml). No entanto, neste caso, parece que a linha está
												 * comentada.
												 */

	public boolean instanciaDB() { /*
									 * Este é um método chamado instanciaDB. Ele parece ser responsável por iniciar
									 * ou criar o banco de dados. Retorna um booleano indicando se a operação foi
									 * bem-sucedida.
									 */

		this.dbService.instanciaDB();

		return true;
	}

}
