package maze.solvers;

import java.util.*;
import maze.model.Maze;
import maze.model.Spot;
/**
 * This class represents the abstraction of a maze search algorithm.
 *
 * @author CATE SCHICK
 */
public abstract class SearchAlgorithm {
	protected final String myDescription;
	protected Maze myMaze;
	protected Spot myCurrent;
	protected HashMap<Spot, Spot> myPaths;
	private int myCounter;
	protected int myMax;
	private int myBacktracks;
	protected Collection<Spot> myFrontier;

	/**
	 * Create an algorithm with its name.
	 */
	public SearchAlgorithm (String description) {
		myDescription = description;
	}

	/**
	 * Returns the number of steps taken
	 */
	public int getSteps(){
		return myCounter;
	}

	/**
	 * Returns the maximum size the data structure has
	 * been while exploring the maxe
	 */
	public int getMax(){
		return myMax;
	}

	/**
	 * Returns the number of backtracks (The number of times a new path is created)
	 */
	public int getBacktracks(){
		return myBacktracks;
	}

	/**
	 * Take one step searching for solution path for the maze.
	 */
	public boolean step () {
		myCounter++;

		// Step 1: Color Successful Path (Overrides in DFS, RandomWalk)
		if (colorSuccessfulPath()) {
			return true;
		}

		// Step 2: Get Neighbors (Used in all methods)
		List<Spot> neighbors = getNeighbors();

		// Step 3: Sort Closest to Goal (Override in Greedy)
		sortNodes(neighbors);

		// Step 4: Choose next spot (Overrides in Magic and RandomWalk)
		Spot next = getNextStep(neighbors);

		// Step 5: Compare current distance to goal with next steps's distance to goal
		// to determine if function backtracked (-1 is current spot is closer than next)
		if (compareSpots(next) == -1) {
			myBacktracks++;
		}

		// Step 6: Mark next step and update
		markNextStep(next);

		// Step 7: Set max size
		myMax = getMax();

		// Step 8: Check for win
		if (successfulSearch()) {
			return true;
		}

		// Step 9: Check if search unsuccessful
		return unsuccessfulSearch();
	}

	public int compareSpots(Spot next) {
		if (next != null) {
			return myCurrent.compareTo(next);
		}
		return 0;
	}

	/**
	 * This function finds all the neighbors of a current point
	 * @return a list of neighbors from the current point in the maze
	 */
	protected List<Spot> getNeighbors() {
		return myMaze.getNeighbors(myCurrent);
	}

	/**
	 *
	 * @param neighbors - neighboring points
	 * @return the next step according to algorithm
	 */
	protected Spot getNextStep (List<Spot> neighbors) {
		Spot next = null;
		// Check all neighboring points
		for (Spot spot : neighbors) {
			// if nearest spot is unexplored, select it
			if (spot.getState() == Spot.EMPTY) {
				next = spot;
				break;
			}
		}
		return next;
	}

	/**
	 * Step 1 determines if the search is over and colors the path
	 * @return if the search is over
	 */
	protected boolean colorSuccessfulPath() {
		if (unsuccessfulSearch()) {
			markPath();
			return true;
		}
		return false;
	}

	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString () {
		return myDescription;
	}

	/**
	 * 	Search is over and unsuccessful if there are no more fringe points to consider.
	 * @return status of search
	 */
	protected boolean unsuccessfulSearch() {
		return false;
	}

	/**
	 * This function determines if the current spot on the map
	 * is equal to the goal node
	 * @return whether the current point is equal to the goal point
	 */
	public boolean successfulSearch() {
		return myCurrent.equals(myMaze.getGoal());
	}

	/**
	 * 	When the search is over, color the chosen correct path using trail of successful spots
	 */
	protected void markPath() {
		Spot step = myMaze.getGoal();
		while (step != null) {
			step.markAsPath();
			step = myPaths.get(step);
		}
	}

	protected abstract void sortNodes(List<Spot> neighbors);

	/**
	 * This method is dependent on the data structure of myFrontier and is different for all search algorithms
	 */
	protected void markNextStep(Spot next){
		// mark next step, if it exists
		if (next != null) {
			next.markAsPath();
			addSpot(next);
			addPaths(next);
		}
		else {
			myCurrent.markAsVisited();
			removeSpot();
		}
		myCurrent = peek(myFrontier);
	}

	protected abstract Spot peek(Collection list);

	protected void addSpot(Spot next) {
		myFrontier.add(next);
	}

	void removeSpot() {
		myFrontier.remove(myCurrent);
	}

	protected void addPaths(Spot next) {
		myPaths.put(next, myCurrent);
	}
}
