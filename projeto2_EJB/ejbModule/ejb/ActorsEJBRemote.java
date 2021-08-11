package ejb;

import java.util.List;

import javax.ejb.Remote;

import jpa.ActorJPA;
import jpa.MovieJPA;

@Remote
public interface ActorsEJBRemote {

	List<ActorJPA> getActors();

	List<ActorJPA> getActorByName(String name);

	List<ActorJPA> getActorsInfoByMovieTitle(String title);

	void addActor(String name, List<String> movies_rank);

	MovieJPA getNewActorsMovie(int rank_position);

}
