package projetEchec.pieces;

import java.util.EventListener;

import projetEchec.UI.Cell;

public interface IMovementListener extends EventListener {
	void positionChanged(Cell oldCell, Cell newCell);
}
