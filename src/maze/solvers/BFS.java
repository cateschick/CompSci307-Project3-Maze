package maze.solvers;

import java.util.*;

import maze.model.Maze;
import maze.model.Spot;

/**
 * This class represents a Breadth-First maze search algorithm.
 *
 * @author CATE SCHICK
 */
public class BFS extends SearchAlgorithm {
	private static final String TITLE = "Breadth-First";

	public BFS (Maze maze) {
		super(TITLE);
		myMaze = maze;
		myFrontier = new LinkedList<>();
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
	public int getMax() {
		if (myFrontier.size() >= myMax) {
			myMax = myFrontier.size();
		}
		return myMax;
	}

	@Override
	protected void addPaths(Spot next){
	}

	@Override
	// Gets around Collection issues and peek
	protected Spot peek(Collection list) {
		Queue<Spot> l = (Queue<Spot>) list;
		return l.peek();
	}
}

