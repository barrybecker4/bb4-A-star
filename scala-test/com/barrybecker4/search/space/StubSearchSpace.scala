// Copyright by Barry G. Becker, 2017. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.search.space

import com.barrybecker4.search.{StubProblem, StubState, StubTransition}


/**
  * A fake, very simple, search space for use in unit tests.
  * Teh StubNodes define a network, with costs on edges, that can be searched by A*.
  * See https://en.wikipedia.org/wiki/A*_search_algorithm (where I get this example)
  *
  * @author Barry Becker
  */
object StubSearchSpace {
  private val PROBLEM: StubProblem = new StubProblem
}

class StubSearchSpace
  extends AbstractSearchSpace[StubState, StubTransition](StubSearchSpace.PROBLEM.getInitialState) {

  def isGoal(state: StubState): Boolean = state == StubSearchSpace.PROBLEM.getGoalState

  def legalTransitions(state: StubState): Seq[StubTransition] = StubSearchSpace.PROBLEM.getLegalTransitions(state)

  def transition(state: StubState, transition: StubTransition): StubState = transition.newState

  def distanceFromGoal(state: StubState): Int = state.getDistanceFromGoal

  override def getCost(transition: StubTransition): Int = transition.cost

  override def animateTransition(transition: StubTransition): StubState = transition.newState
}
