package maze.solvers;

import java.util.*;

import maze.model.Maze;
import maze.model.Spot;


/**
 * This class represents a Depth-First maze search algorithm.
 *
 * @author CATE SCHICK
 */
public class DFS extends SearchAlgorithm {
	private static final String TITLE = "Depth-First";
	private final Stack<Spot> myFrontier;

	public DFS (Maze maze) {
		super(TITLE);
		myMaze = maze;
		myFrontier = new Stack<>();
		myCurrent = maze.getStart();
		myCurrent.markAsPath();
		myFrontier.push(myCurrent);
		myPaths = new HashMap<>();
	}

	@Override
	protected boolean colorSuccessfulPath(){
		return false;
	}

	@Override
	protected boolean unsuccessfulSearch() {
		return myFrontier.isEmpty();
	}

	@Override
	protected void sortNodes(List<Spot> neighbors) {
	}

	@Override
	protected void markNextStep(Spot next) {
		// mark next step, if it exists
		if (next != null) {
			next.markAsPath();
			myFrontier.push(next);
		}
		else {
			myCurrent.markAsVisited();
			myFrontier.pop();
		}
		myCurrent = peek(myFrontier);
	}

	@Override
	public int getMax() {
		if (myFrontier.size() >= myMax) {
			myMax = myFrontier.size();
		}
		return myMax;
	}

	@Override
	public void addSpot(Spot next){
		myFrontier.push(next);
	}

	@Override
	public void removeSpot() {
		myFrontier.pop();
	}

	@Override
	protected void addPaths(Spot next){
	}

	@Override
	// Gets around Collection issues and peek
	protected Spot peek(Collection list) {
		Stack<Spot> l = (Stack<Spot>) list;
		return l.peek();
	}
}
