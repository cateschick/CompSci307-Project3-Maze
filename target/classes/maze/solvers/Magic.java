package maze.solvers;

import java.util.*;

import maze.model.Maze;
import maze.model.Spot;
import maze.util.Randomness;


/**
 * This class represents a Magic maze search algorithm.
 *
 * @author CATE SCHICK
 */
public class Magic extends SearchAlgorithm {
	private static final String TITLE = "Magic";
	private final PriorityQueue<Spot> myFrontier;

	public Magic (Maze maze) {
		super(TITLE);
		myMaze = maze;
		myFrontier = new PriorityQueue<>();
		myCurrent = maze.getStart();
		myCurrent.markAsPath();
		myFrontier.add(myCurrent);
		myPaths = new HashMap<>();
	}

	@Override
	protected boolean unsuccessfulSearch() {
		return myFrontier.isEmpty();
	}

	@Override
	protected void sortNodes(List<Spot> neighbors) {
	}

	@Override
	protected Spot getNextStep(List<Spot> neighbors){
		return Randomness.getRandomElement(neighbors);
	}

	@Override
	public int getMax() {
		if (myFrontier.size() >= myMax) {
			myMax = myFrontier.size();
		}
		return myMax;
	}

	@Override
	protected void addSpot(Spot next) {
		myFrontier.add(next);
	}

	@Override
	// Gets around Collection issues and peek
	protected Spot peek(Collection list) {
		return myFrontier.peek();
	}
}
