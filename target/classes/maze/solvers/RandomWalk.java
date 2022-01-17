package maze.solvers;

import java.util.*;

import maze.model.Maze;
import maze.model.Spot;
import maze.util.Randomness;


/**
 * This class represents a random maze search algorithm.
 *
 * @author CATE SCHICK
 */
public class RandomWalk extends SearchAlgorithm {
	private static final String TITLE = "Random Walk";
	private final double EXPLORE_BIAS = 0.999;

	public RandomWalk (Maze maze) {
		super(TITLE);
		myMaze = maze;
		myCurrent = maze.getStart();
		myCurrent.markAsPath();
		myPaths = new HashMap<>();
	}

	@Override
	protected Spot getNextStep(List<Spot> neighbors) {
		Spot next;
		List<Spot> empties = new ArrayList<>();
		List<Spot> possibles = new ArrayList<>();
		for (Spot spot : neighbors) {
			if (spot.getState() == Spot.EMPTY) {
				empties.add(spot);
			}
			if (spot.getState() != Spot.WALL) {
				possibles.add(spot);
			}
		}
		if (! empties.isEmpty() && Randomness.isRandomEnough(EXPLORE_BIAS)) {
			next = Randomness.getRandomElement(empties);
		}
		next = Randomness.getRandomElement(possibles);
		return next;
	}

	@Override
	protected boolean colorSuccessfulPath(){
		return false;
	}

	@Override
	protected void sortNodes(List<Spot> neighbors) {
	}

	@Override
	protected void markNextStep(Spot next){
		next.markAsPath();
		myCurrent.markAsVisited();
		myCurrent = next;
	}

	@Override
	protected void addPaths(Spot next) {
	}

	@Override
	// Gets around Collection issues and peek
	protected Spot peek(Collection list)  {
		return null;
	}
}
