package maze.solvers;

import java.util.*;

import maze.model.Maze;
import maze.model.Spot;


/**
 * This class represents a Greedy maze search algorithm.
 *
 * @author CATE SCHICK
 */
public class Greedy extends SearchAlgorithm {
	private static final String TITLE = "Greedy";
	private final PriorityQueue<Spot> myFrontier;

	public Greedy (Maze maze) {
		super(TITLE);
		myMaze = maze;
		myFrontier = new PriorityQueue<>();
		myCurrent = maze.getStart();
		myCurrent.markAsPath();
		myFrontier.add(myCurrent);
		myPaths = new HashMap<>();
	}

	@Override
	protected void sortNodes(List<Spot> neighbors){
		Collections.sort(neighbors);
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
	protected void removeSpot() {
		myFrontier.remove(myCurrent);
	}

	@Override
	// Gets around Collection issues and peek
	protected Spot peek(Collection list) {
		return myFrontier.peek();
	}
}
