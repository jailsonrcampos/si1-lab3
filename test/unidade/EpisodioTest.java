package unidade;

import models.Episodio;
import models.Serie;
import models.Temporada;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.*;

/**
 * Created by orion on 06/12/14.
 */
public class EpisodioTest {

    Episodio episodio;

    @Test
    public void naoDeveAdicionarEpisodioComNomeVazio(){
        try {
            Serie serie = new Serie("Sons of Anarchy");
            Temporada temporada = new Temporada(1, serie);
            episodio = new Episodio("", temporada, 1);
            fail();
        } catch (Exception e){
            assertTrue(episodio == null);
        }
    }

    @Test
    public void naoDeveAdicionarEpisodioComTemporadaNula(){
        try {
            episodio = new Episodio("Episódio 1", null, 1);
            fail();
        } catch (Exception e){
            assertTrue(episodio == null);
        }
    }

    @Test
    public void naoDeveAdicionarEpisodioComNumeroNegativo(){
        try {
            Serie serie = new Serie("Sons of Anarchy");
            Temporada temporada = new Temporada(1, serie);
            episodio = new Episodio("Episódio 1", temporada, -1);
            fail();
        } catch (Exception e){
            assertTrue(episodio == null);
        }
    }

    @Test
    public void deveConstruirConstrutorCorretamente() throws Exception {
        Serie serie = new Serie("Sons of Anarchy");
        Temporada temporada = new Temporada(1, serie);
        episodio = new Episodio("Episódio 1", temporada, 1);

        assertThat(episodio.getNome()).isEqualTo("Episódio 1");
        assertThat(episodio.getNumero()).isEqualTo(1);
        assertFalse(episodio.isAssistido());
    }

    @Test
    public void deveAssistirEpisodio() throws Exception {
        Serie serie = new Serie("Sons of Anarchy");
        Temporada temporada = new Temporada(1, serie);
        episodio = new Episodio("Episódio 1", temporada, 1);

        assertFalse(episodio.isAssistido());

        episodio.setAssistido(true);
        assertTrue(episodio.isAssistido());
    }
}
