package com.sstengine.player.playerentity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a buffer for inputMoves.
 * Handles what the users next desired action is going to be.
 * Saves up to a certain amount of inputs for movement at the same time and retrieves the oldest input first.
 * Thread safe.
 *
 * @author Oscar de Leeuw
 */
class InputBuffer {
    private Deque<MoveDirection> inputMoves;
    private MoveDirection lastMove = MoveDirection.NONE;

    /**
     * Creates a new InputBuffer.
     */
    InputBuffer() {
        inputMoves = new ArrayDeque<>();
    }

    /**
     * Synchronized method.
     * Adds a given {@link MoveDirection} to the input buffer.
     * If the buffer is full it will remove the oldest element and insert the new one.
     *
     * @param md The input that was given by the user.
     */
    synchronized void addToInputMoves(MoveDirection md) {
        inputMoves.offerFirst(md);
    }

    /**
     * Synchronized method.
     * Gets the newest move in the InputBuffer.
     * If there was a move that differed from the last move, the different move will get priority.
     *
     * @return The highest priority move.
     */
    synchronized MoveDirection getNextInputMove() {
        MoveDirection currentMove = inputMoves.pollFirst();

        if (currentMove == null) {
            return MoveDirection.NONE;
        }

        //If there is another move in the buffer that is different from the last move, send that one instead.
        if (currentMove.equals(lastMove)) {
            List<MoveDirection> otherMoves = inputMoves.stream().filter(move -> !move.equals(lastMove)).collect(Collectors.toList());
            if (!otherMoves.isEmpty()) {
                currentMove = otherMoves.get(0);
            }
        }

        lastMove = currentMove;
        inputMoves.clear();
        return currentMove;
    }
}
