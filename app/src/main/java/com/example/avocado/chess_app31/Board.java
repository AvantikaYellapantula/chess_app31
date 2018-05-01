package com.example.avocado.chess_app31;
/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */


import java.util.ArrayList;
import java.util.List;



public class Board {


	public List<Move> allMoves;

	public Tile[][] game_board;
	public boolean drawProposal;
	public boolean whiteTurn;
	public Tile previousTile;

	public Board() {
		game_board = new Tile[8][8];
		allMoves= new ArrayList<Move>();
		whiteTurn = true;
		this.initialize_board();

	}

	/**
	 * Decides whose turn it is
	 *
	 * @param
	 * @return turn color of boolean type
	 */
	public void turnPicker() {

		this.whiteTurn = !(this.whiteTurn);

		// System.out.println("switch");
	}

	/**
	 * Initializes the board, to no pieces or colored tiles
	 *
	 * @param
	 * @return none
	 */
	public void initialize_board() {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				game_board[i][j] = new Tile(new PairCoordinate(i, j), null);
			}
		}
		// set up the board

		// set up white pieces
		// pawns -> white:

		for (int i = 0; i < 8; i++) {
			game_board[1][i].piece = new Pawn(false);
		}

		// pawns -> black
		for (int i = 0; i < 8; i++) {
			game_board[6][i].piece = new Pawn(true);
		}

		// Queen -> white


		//Rook ->
		game_board[0][0].piece = new Rook(false);

		game_board[0][7].piece = new Rook(false);

		game_board[7][0].piece = new Rook(true);
		game_board[7][7].piece = new Rook(true);

		game_board[0][1].piece = new Knight(false);
		game_board[0][6].piece = new Knight(false);

		game_board[7][1].piece = new Knight(true);
		game_board[7][6].piece = new Knight(true);

		game_board[0][2].piece = new Bishop(false);

		game_board[0][5].piece = new Bishop(false);

		game_board[7][2].piece = new Bishop(true);
		game_board[7][5].piece = new Bishop(true);

		game_board[0][3].piece = new Queen(false);
		game_board[7][3].piece = new Queen(true);


		game_board[0][4].piece = new King(false);
		// King -> white
		game_board[7][4].piece = new King(true);

	}

	/**
	 * This method covers all the cases for the check process in chess. It
	 * determines the king's location and checks in every direction around him to
	 * make sure that there are no threatening pieces. If there are, the system will
	 * print out "white/black is in check"
	 *
	 * @param
	 * @return boolean false/true that check is in place
	 */
	public boolean check() {
		// sees if a player has a check on king!
		PairCoordinate kingLoc = getKingLocation();
		if (whiteTurn == true) { // WHITE KING CHECK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			for (int i = kingLoc.m_file + 1; i < 8; i++) { // horizontal check right of king
				if (this.game_board[kingLoc.m_rank][i].isEmpty() == false) {
					if (this.game_board[kingLoc.m_rank][i].piece.color == false) {
						if (this.game_board[kingLoc.m_rank][i].piece instanceof King && kingLoc.m_file + 1 == i) {
							return true;
						} else if (this.game_board[kingLoc.m_rank][i].piece instanceof Rook
								|| this.game_board[kingLoc.m_rank][i].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
			for (int i = kingLoc.m_file - 1; i >= 0; i--) { // horizontal check left of king
				if (this.game_board[kingLoc.m_rank][i].isEmpty() == false) {
					if (this.game_board[kingLoc.m_rank][i].piece.color == false) {
						if (this.game_board[kingLoc.m_rank][i].piece instanceof King && kingLoc.m_file - 1 == i) {
							return true;
						} else if (this.game_board[kingLoc.m_rank][i].piece instanceof Rook
								|| this.game_board[kingLoc.m_rank][i].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
			for (int i = kingLoc.m_rank - 1; i >= 0; i--) { // vertical check above king
				if (this.game_board[i][kingLoc.m_file].isEmpty() == false) {
					if (this.game_board[i][kingLoc.m_file].piece.color == false) {
						if (this.game_board[i][kingLoc.m_file].piece instanceof King && kingLoc.m_rank - 1 == i) {
							return true;
						} else if (this.game_board[i][kingLoc.m_file].piece instanceof Rook
								|| this.game_board[i][kingLoc.m_file].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
			for (int i = kingLoc.m_rank + 1; i < 8; i++) { // vertical check below king
				if (this.game_board[i][kingLoc.m_file].isEmpty() == false) {
					if (this.game_board[i][kingLoc.m_file].piece.color == false) {
						if (this.game_board[i][kingLoc.m_file].piece instanceof King && kingLoc.m_rank + 1 == i) {
							return true;
						} else if (this.game_board[i][kingLoc.m_file].piece instanceof Rook
								|| this.game_board[i][kingLoc.m_file].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}

			int tempFile = kingLoc.m_file + 1;
			int tempRank = kingLoc.m_rank + 1;
			while (tempRank < 8 && tempFile < 8) { // diagonal check right below king

				if (this.game_board[tempRank][tempFile].isEmpty() == false) {
					if (this.game_board[tempRank][tempFile].piece.color == false) {
						if (this.game_board[tempRank][tempFile].piece instanceof King && kingLoc.m_rank + 1 == tempRank
								&& kingLoc.m_file + 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof Bishop
								|| this.game_board[tempRank][tempFile].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}
				}

				tempFile += 1;
				tempRank += 1;
			}
			tempFile = kingLoc.m_file - 1;
			tempRank = kingLoc.m_rank + 1;
			while (tempRank < 8 && tempFile >= 0) { // diagonal check left below king

				if (this.game_board[tempRank][tempFile].isEmpty() == false) {
					if (this.game_board[tempRank][tempFile].piece.color == false) {
						if (this.game_board[tempRank][tempFile].piece instanceof King && kingLoc.m_rank + 1 == tempRank
								&& kingLoc.m_file - 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof Bishop
								|| this.game_board[tempRank][tempFile].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}
				}

				tempFile -= 1;
				tempRank += 1;
			}

			tempFile = kingLoc.m_file + 1;
			tempRank = kingLoc.m_rank - 1;
			while (tempRank >= 0 && tempFile < 8) { // diagonal check right above king

				if (this.game_board[tempRank][tempFile].isEmpty() == false) {

					if (this.game_board[tempRank][tempFile].piece.color == false) {
						if (this.game_board[tempRank][tempFile].piece instanceof Pawn && kingLoc.m_rank - 1 == tempRank
								&& kingLoc.m_file + 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof King
								&& kingLoc.m_rank - 1 == tempRank && kingLoc.m_file + 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof Bishop
								|| this.game_board[tempRank][tempFile].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}
				}

				tempFile += 1;
				tempRank -= 1;
			}

			tempFile = kingLoc.m_file - 1;
			tempRank = kingLoc.m_rank - 1;
			while (tempRank >= 0 && tempFile >= 0) { // diagonal check left above king

				if (this.game_board[tempRank][tempFile].isEmpty() == false) {
					if (this.game_board[tempRank][tempFile].piece.color == false) {
						if (this.game_board[tempRank][tempFile].piece instanceof Pawn && kingLoc.m_rank - 1 == tempRank
								&& kingLoc.m_file - 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof King
								&& kingLoc.m_rank - 1 == tempRank && kingLoc.m_file - 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof Bishop
								|| this.game_board[tempRank][tempFile].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}
				}

				tempFile -= 1;
				tempRank -= 1;
			}

			try {
				if (this.game_board[kingLoc.m_rank - 1][kingLoc.m_file + 2].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 1][kingLoc.m_file + 2].piece.color == false) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank - 2][kingLoc.m_file + 1].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 2][kingLoc.m_file + 1].piece.color == false) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank - 2][kingLoc.m_file - 1].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 2][kingLoc.m_file - 1].piece.color == false) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank - 1][kingLoc.m_file - 2].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 1][kingLoc.m_file - 2].piece.color == false) {
					return true;
				}

				if (this.game_board[kingLoc.m_rank + 1][kingLoc.m_file - 2].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank + 1][kingLoc.m_file - 2].piece.color == false) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank + 1][kingLoc.m_file + 2].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 1][kingLoc.m_file + 2].piece.color == false) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank + 2][kingLoc.m_file - 1].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank + 2][kingLoc.m_file - 1].piece.color == false) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank + 2][kingLoc.m_file + 1].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank + 2][kingLoc.m_file + 1].piece.color == false) {
					return true;
				}
			} catch (IndexOutOfBoundsException e) {

			} catch (NullPointerException e) {

			}
			// finally the L shape path check sigh *********************

		}

		else {// if its black turn then we look out for white pieces tryna kill black king
			for (int i = kingLoc.m_file + 1; i < 8; i++) { // horizontal check right of king
				if (this.game_board[kingLoc.m_rank][i].isEmpty() == false) {
					if (this.game_board[kingLoc.m_rank][i].piece.color == true) {
						if (this.game_board[kingLoc.m_rank][i].piece instanceof King && kingLoc.m_file + 1 == i) {
							return true;
						} else if (this.game_board[kingLoc.m_rank][i].piece instanceof Rook
								|| this.game_board[kingLoc.m_rank][i].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;

					}
				}
			}
			for (int i = kingLoc.m_file - 1; i >= 0; i--) { // horizontal check left of king
				if (this.game_board[kingLoc.m_rank][i].isEmpty() == false) {
					if (this.game_board[kingLoc.m_rank][i].piece.color == true) {
						if (this.game_board[kingLoc.m_rank][i].piece instanceof King && kingLoc.m_file - 1 == i) {
							return true;
						} else if (this.game_board[kingLoc.m_rank][i].piece instanceof Rook
								|| this.game_board[kingLoc.m_rank][i].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;

					}
				}
			}
			for (int i = kingLoc.m_rank - 1; i >= 0; i--) { // vertical check above king
				if (this.game_board[i][kingLoc.m_file].isEmpty() == false) {
					if (this.game_board[i][kingLoc.m_file].piece.color == true) {
						if (this.game_board[i][kingLoc.m_file].piece instanceof King && kingLoc.m_rank - 1 == i) {
							return true;
						} else if (this.game_board[i][kingLoc.m_file].piece instanceof Rook
								|| this.game_board[i][kingLoc.m_file].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}

				}
			}

			for (int i = kingLoc.m_rank + 1; i < 8; i++) { // vertical check below king
				if (this.game_board[i][kingLoc.m_file].isEmpty() == false) {
					if (this.game_board[i][kingLoc.m_file].piece.color == true) {
						if (this.game_board[i][kingLoc.m_file].piece instanceof King && kingLoc.m_rank + 1 == i) {
							return true;
						} else if (this.game_board[i][kingLoc.m_file].piece instanceof Rook
								|| this.game_board[i][kingLoc.m_file].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}

				}
			}

			int tempFile = kingLoc.m_file + 1;
			int tempRank = kingLoc.m_rank + 1;
			while (tempRank < 8 && tempFile < 8) { // diagonal check right below king

				if (this.game_board[tempRank][tempFile].isEmpty() == false) {
					if (this.game_board[tempRank][tempFile].piece.color == true) {
						if (this.game_board[tempRank][tempFile].piece instanceof Pawn && kingLoc.m_rank + 1 == tempRank
								&& kingLoc.m_file + 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof King
								&& kingLoc.m_rank + 1 == tempRank && kingLoc.m_file + 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof Bishop
								|| this.game_board[tempRank][tempFile].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}

				}

				tempFile += 1;
				tempRank += 1;
			}
			tempFile = kingLoc.m_file - 1;
			tempRank = kingLoc.m_rank + 1;
			while (tempRank < 8 && tempFile >= 0) { // diagonal check left below king

				if (this.game_board[tempRank][tempFile].isEmpty() == false) {
					if (this.game_board[tempRank][tempFile].piece.color == true) {
						if (this.game_board[tempRank][tempFile].piece instanceof Pawn && kingLoc.m_rank + 1 == tempRank
								&& kingLoc.m_file - 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof King
								&& kingLoc.m_rank + 1 == tempRank && kingLoc.m_file - 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof Bishop
								|| this.game_board[tempRank][tempFile].piece instanceof Queen) {

							return true;
						} else {// its a piece that cant kill you and blocks a piece that can kill you so your
							// safe
							break;
						}
					} else {
						break;
					}

				}

				tempFile -= 1;
				tempRank += 1;
			}

			tempFile = kingLoc.m_file + 1;
			tempRank = kingLoc.m_rank - 1;
			while (tempRank >= 0 && tempFile < 8) { // diagonal check right above king

				if (this.game_board[tempRank][tempFile].isEmpty() == false) {
					if (this.game_board[tempRank][tempFile].piece.color == true) {

						if (this.game_board[tempRank][tempFile].piece instanceof King && kingLoc.m_rank - 1 == tempRank
								&& kingLoc.m_file + 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof Bishop
								|| this.game_board[tempRank][tempFile].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}

				}

				tempFile += 1;
				tempRank -= 1;
			}

			tempFile = kingLoc.m_file - 1;
			tempRank = kingLoc.m_rank - 1;
			while (tempRank >= 0 && tempFile >= 0) { // diagonal check left above king

				if (this.game_board[tempRank][tempFile].isEmpty() == false) {
					if (this.game_board[tempRank][tempFile].piece.color == true) {

						if (this.game_board[tempRank][tempFile].piece instanceof King && kingLoc.m_rank - 1 == tempRank
								&& kingLoc.m_file - 1 == tempFile) {
							return true;
						} else if (this.game_board[tempRank][tempFile].piece instanceof Bishop
								|| this.game_board[tempRank][tempFile].piece instanceof Queen) {
							return true;
						} else {
							break;
						}
					} else {
						break;
					}

				}

				tempFile -= 1;
				tempRank -= 1;
			}

			try {
				if (this.game_board[kingLoc.m_rank - 1][kingLoc.m_file + 2].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 1][kingLoc.m_file + 2].piece.color == true) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank - 2][kingLoc.m_file + 1].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 2][kingLoc.m_file + 1].piece.color == true) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank - 2][kingLoc.m_file - 1].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 2][kingLoc.m_file - 1].piece.color == true) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank - 1][kingLoc.m_file - 2].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank - 1][kingLoc.m_file - 2].piece.color == true) {
					return true;
				}

				if (this.game_board[kingLoc.m_rank + 1][kingLoc.m_file - 2].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank + 1][kingLoc.m_file - 2].piece.color == true) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank + 1][kingLoc.m_file + 2].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank + 1][kingLoc.m_file + 2].piece.color == true) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank + 2][kingLoc.m_file - 1].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank + 2][kingLoc.m_file - 1].piece.color == true) {
					return true;
				}
				if (this.game_board[kingLoc.m_rank + 2][kingLoc.m_file + 1].piece instanceof Knight
						&& this.game_board[kingLoc.m_rank + 2][kingLoc.m_file + 1].piece.color == true) {
					return true;
				}
			}

			catch (IndexOutOfBoundsException e) {

			}

			catch (NullPointerException e) {

			}

		}

		return false;// end for both white or black king
	}

	/**
	 * Gets the king's location
	 *
	 * @param
	 * @return location of type PairCoordinate
	 */
	public PairCoordinate getKingLocation() {

		PairCoordinate location = new PairCoordinate(0, 0);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if (this.whiteTurn == true) {
					if (this.game_board[i][j].piece instanceof King && this.game_board[i][j].piece.color == true) {
						location.m_rank = i;
						location.m_file = j;
						return location;
					}
				} else {
					if (this.game_board[i][j].piece instanceof King && this.game_board[i][j].piece.color == false) {
						location.m_rank = i;
						location.m_file = j;
						return location;
					}
				}

			}
		}

		return null;
	}

	public boolean checkFlag;
	public boolean pawnBoardState;

	/**
	 * boardMove tells whether there's a piece already in the path of the moving
	 * piece, or whether the player is attempting to move the opposing player's
	 * piece or whether that piece cannot be moved.
	 *
	 * @param
	 *            start,PairCoordinate end,String Promote
	 * @return boolean true/false
	 */
	public boolean boardMove(PairCoordinate start, PairCoordinate end, String Promote) {



		allCases special = new allCases();

		Tile startTile = game_board[start.m_rank][start.m_file];

		Tile endTile = game_board[end.m_rank][end.m_file];

		Piece movingPiece = startTile.piece;

		Piece endPiece = endTile.piece;
		Move validMove= new Move (movingPiece,endPiece,startTile,endTile);


		if (movingPiece == null) {
			// System.out.println("No piece to move is at this spot");
			return false;

		}

		if (endPiece != null) {
			special.isCapturing = true;

		} else {
			special.isCapturing = false;
		}

		special.pieceInPath = this.hasPieceInPath(start, end);

		if (start.equals(end)) {
			// System.out.println("Cant move to the same tile your on");
			return false;
		}
		if (movingPiece.color == false && this.whiteTurn) {
			// System.out.println("Can not move opponents piece");
			return false;
		}
		if (movingPiece.color == true && this.whiteTurn == false) {
			// System.out.println("Can not move opponents piece");
			return false;
		}

		if ((endPiece != null && (endPiece.color == true && this.whiteTurn == true))
				|| (endPiece != null && (endPiece.color == false && this.whiteTurn == false))) {
			// System.out.println("Can NOT capture your own piece");
			return false;
		}

		if (movingPiece.isOkMove(start, end, special)) { // this checks to see if it has special cases
			// below stuff may be placed in wrong area
			// pass the board for enpassant honestly
			if (pawnBoardState == true) {
				if (!(movingPiece instanceof Pawn)) {
					Pawn enPassantable = (Pawn) previousTile.piece;
					enPassantable.enpassantFlag = false;
				}

				else {
					Pawn movePawn = (Pawn) movingPiece;

					if (special.enPassant != true) {
						Pawn enPassantable = (Pawn) previousTile.piece;
						enPassantable.enpassantFlag = false;
					}

				}
				pawnBoardState = false;
			}

			if (movingPiece instanceof Pawn && pawnBoardState == false) {
				Pawn piecePawn = (Pawn) movingPiece;
				if (piecePawn.enpassantFlag == true) {
					pawnBoardState = true;
					previousTile = endTile;
				}
			}

			    special.Castling=false;//get rid of special cases
			if (special.Castling == true) {
				Piece backupStart = this.game_board[start.m_rank][start.m_file].piece;
				Piece backupEnd = this.game_board[end.m_rank][end.m_file].piece;

				if (checkFlag == true) {// NEITHER PIECE CAN BE IN CHECK in order for castking to work
					return false;
				}

				if (whiteTurn == true && end.m_file == 6) {
					if (this.game_board[7][7].piece instanceof Rook) {
						Rook rook = (Rook) this.game_board[7][7].piece;
						if (rook.isFirstMove == true) {
							this.game_board[7][5].piece = this.game_board[7][7].piece;
							this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;
							this.game_board[7][7].piece = null;
							this.game_board[start.m_rank][start.m_file].piece = null;

							checkFlag = this.check();
							if (checkFlag == true) {
								this.game_board[7][5].piece = null;
								this.game_board[7][7].piece = new Rook(true);
								this.game_board[start.m_rank][start.m_file].piece = backupStart;
								this.game_board[end.m_rank][end.m_file].piece = backupEnd;

								return false;
							} else {

								allMoves.add(validMove);
								this.turnPicker();

								checkFlag = this.check();
								if (checkFlag == true && this.whiteTurn == true) {
									//	System.out.println("Check");
								}
								if (checkFlag == true && this.whiteTurn == false) {
									//	System.out.println("Check");
								}
								return true;
							}
						}
					}

				}
				if (whiteTurn == true && end.m_file == 2) {
					if (this.game_board[7][0].piece instanceof Rook) {
						Rook rook = (Rook) this.game_board[7][0].piece;
						if (rook.isFirstMove == true) {
							if (this.game_board[7][1].piece == null && this.game_board[7][2].piece == null) {
								this.game_board[7][3].piece = this.game_board[7][0].piece;
								this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;
								this.game_board[7][0].piece = null;
								this.game_board[start.m_rank][start.m_file].piece = null;

								checkFlag = this.check();
								if (checkFlag == true) {// you put yourself in check so revert this move
									this.game_board[7][3].piece = null;
									this.game_board[7][0].piece = new Rook(true);
									this.game_board[start.m_rank][start.m_file].piece = backupStart;
									this.game_board[end.m_rank][end.m_file].piece = backupEnd;

									return false;
								} else {
									allMoves.add(validMove);
									this.turnPicker();

									checkFlag = this.check();
									if (checkFlag == true && this.whiteTurn == true) {
										//	System.out.println("Check");
									}
									if (checkFlag == true && this.whiteTurn == false) {
										//	System.out.println("Check");
									}
									return true;

								}

							}
						}
					}

				}

				if (whiteTurn == false && end.m_file == 6) {
					if (this.game_board[0][7].piece instanceof Rook) {
						Rook rook = (Rook) this.game_board[0][7].piece;
						if (rook.isFirstMove == true) {
							this.game_board[0][5].piece = this.game_board[0][7].piece;
							this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;
							this.game_board[0][7].piece = null;
							this.game_board[start.m_rank][start.m_file].piece = null;

							checkFlag = this.check();
							if (checkFlag == true) {// you put yourself in check so revert this move
								this.game_board[0][5].piece = null;
								this.game_board[0][7].piece = new Rook(false);
								this.game_board[start.m_rank][start.m_file].piece = backupStart;
								this.game_board[end.m_rank][end.m_file].piece = backupEnd;

								return false;
							} else {
								allMoves.add(validMove);
								this.turnPicker();

								checkFlag = this.check();
								if (checkFlag == true && this.whiteTurn == true) {
									//	System.out.println("Check");
								}
								if (checkFlag == true && this.whiteTurn == false) {
									//	System.out.println("Check");
								}
								return true;
							}
						}
					}

				}
				if (whiteTurn == false && end.m_file == 2) {
					if (this.game_board[0][0].piece instanceof Rook) {
						Rook rook = (Rook) this.game_board[0][0].piece;
						if (rook.isFirstMove == true) {
							if (this.game_board[0][1].piece == null && this.game_board[0][2].piece == null) {
								this.game_board[0][3].piece = this.game_board[0][0].piece;
								this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;
								this.game_board[0][0].piece = null;
								this.game_board[start.m_rank][start.m_file].piece = null;

								checkFlag = this.check();
								if (checkFlag == true) {// you put yourself in check so revert this move
									this.game_board[0][3].piece = null;
									this.game_board[0][0].piece = new Rook(false);
									this.game_board[start.m_rank][start.m_file].piece = backupStart;
									this.game_board[end.m_rank][end.m_file].piece = backupEnd;

									return false;
								} else {
									allMoves.add(validMove);
									this.turnPicker();

									checkFlag = this.check();
									if (checkFlag == true && this.whiteTurn == true) {
										//		System.out.println("Check");
									}
									if (checkFlag == true && this.whiteTurn == false) {
										//		System.out.println("Check");
									}
									return true;
								}
							}

						}
					}

				}

				return false;

			}
			special.enPassant=false;
			if (special.enPassant == true) {

				Piece backupStart = this.game_board[start.m_rank][start.m_file].piece;
				Piece backupEnd = this.game_board[end.m_rank][end.m_file].piece;
				if (start.m_rank == 3 && whiteTurn == true) {
					if (start.m_file - 1 == end.m_file) {
						if ((this.game_board[start.m_rank][start.m_file - 1].piece instanceof Pawn)) {
							Pawn pwnPiece = (Pawn) this.game_board[start.m_rank][start.m_file - 1].piece;
							if (pwnPiece.color == false && pwnPiece.enpassantFlag == true) {
								this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;

								this.game_board[start.m_rank][start.m_file].piece = null;
								// eliminate original piece
								this.game_board[start.m_rank][start.m_file - 1].piece = null;

								checkFlag = this.check(); // MAY NEED TO ALSO PUT ANOTHER CHECK HERE FOR CURRENT PLAYER
								// TO SEE IF THE MOVE SCREWS US UP
								if (this.checkFlag == true) {
									this.game_board[end.m_rank][end.m_file].piece = backupEnd;
									this.game_board[start.m_rank][start.m_file].piece = backupStart;
									this.game_board[start.m_rank][start.m_file - 1].piece = new Pawn(false);
									return false;
								} else {

									allMoves.add(validMove);

									this.turnPicker();
									checkFlag = this.check();
									if (checkFlag == true && this.whiteTurn == true) {
										//	System.out.println("Check");
									}
									if (checkFlag == true && this.whiteTurn == false) {
										//	System.out.println("Check");
									}
									return true;
								}

							}
						}
					}
					if (start.m_file + 1 == end.m_file) {
						if ((this.game_board[start.m_rank][start.m_file + 1].piece instanceof Pawn)) {
							Pawn pwnPiece = (Pawn) this.game_board[start.m_rank][start.m_file + 1].piece;
							if (pwnPiece.color == false && pwnPiece.enpassantFlag == true) {// also has to be black
								this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;

								this.game_board[start.m_rank][start.m_file].piece = null;
								// eliminate original piece
								this.game_board[start.m_rank][start.m_file + 1].piece = null;

								// MAY NEED TO ALSO PUT ANOTHER CHECK HERE FOR CURRENT PLAYER TO SEE IF THE MOVE
								// SCREWS US UP
								// elimiate enPassant Piece
								checkFlag = this.check(); // MAY NEED TO ALSO PUT ANOTHER CHECK HERE FOR CURRENT PLAYER
								// TO SEE IF THE MOVE SCREWS US UP
								if (this.checkFlag == true) {
									this.game_board[end.m_rank][end.m_file].piece = backupEnd;
									this.game_board[start.m_rank][start.m_file].piece = backupStart;
									this.game_board[start.m_rank][start.m_file + 1].piece = new Pawn(false);
									return false;
								} else {
									allMoves.add(validMove);
									this.turnPicker();
									checkFlag = this.check();
									if (checkFlag == true && this.whiteTurn == true) {
										//		System.out.println("Check");
									}
									if (checkFlag == true && this.whiteTurn == false) {
										//		System.out.println("Check");
									}
									return true;
								}
							}
						}

					}
				}
				if (start.m_rank == 4 && whiteTurn == false) { // black enpassant
					if (start.m_file - 1 == end.m_file) {
						if ((this.game_board[start.m_rank][start.m_file - 1].piece instanceof Pawn)) {
							Pawn pwnPiece = (Pawn) this.game_board[start.m_rank][start.m_file - 1].piece;
							if (pwnPiece.color == true && pwnPiece.enpassantFlag == true) {
								this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;

								this.game_board[start.m_rank][start.m_file].piece = null;
								// eliminate original piece
								this.game_board[start.m_rank][start.m_file - 1].piece = null;

								checkFlag = this.check(); // MAY NEED TO ALSO PUT ANOTHER CHECK HERE FOR CURRENT PLAYER
								// TO SEE IF THE MOVE SCREWS US UP
								if (this.checkFlag == true) {
									this.game_board[end.m_rank][end.m_file].piece = backupEnd;
									this.game_board[start.m_rank][start.m_file].piece = backupStart;
									this.game_board[start.m_rank][start.m_file - 1].piece = new Pawn(true);
									return false;
								} else {
									allMoves.add(validMove);
									this.turnPicker();
									checkFlag = this.check();
									if (checkFlag == true && this.whiteTurn == true) {
										//		System.out.println("Check");
									}
									if (checkFlag == true && this.whiteTurn == false) {
										//		System.out.println("Check");
									}
									return true;
								}

							}

						}
					}
					if (start.m_file + 1 == end.m_file) {
						if ((this.game_board[start.m_rank][start.m_file + 1].piece instanceof Pawn)) {
							Pawn pwnPiece = (Pawn) this.game_board[start.m_rank][start.m_file + 1].piece;
							if (pwnPiece.color == true && pwnPiece.enpassantFlag == true) {// also has to be black
								this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;

								this.game_board[start.m_rank][start.m_file].piece = null;
								// eliminate original piece
								this.game_board[start.m_rank][start.m_file + 1].piece = null;

								checkFlag = this.check(); // MAY NEED TO ALSO PUT ANOTHER CHECK HERE FOR CURRENT PLAYER
								// TO SEE IF THE MOVE SCREWS US UP
								if (this.checkFlag == true) {
									this.game_board[end.m_rank][end.m_file].piece = backupEnd;
									this.game_board[start.m_rank][start.m_file].piece = backupStart;
									this.game_board[start.m_rank][start.m_file + 1].piece = new Pawn(true);
									return false;
								} else {

									allMoves.add(validMove);
									this.turnPicker();
									checkFlag = this.check();
									if (checkFlag == true && this.whiteTurn == true) {
										//			System.out.println("Check");
									}
									if (checkFlag == true && this.whiteTurn == false) {
										//			System.out.println("Check");
									}
									return true;
								}
							}

						}

					}
				}

				return false;

			}
			special.isPromoting=false;
			if (special.isPromoting == true) {
				Piece backupStart = this.game_board[start.m_rank][start.m_file].piece;
				Piece backupEnd = this.game_board[end.m_rank][end.m_file].piece;

				String promotionPieces[] = { "Q", "B", "R", "N" };
				if (Promote == null) {
					if (whiteTurn == true) {
						this.game_board[end.m_rank][end.m_file].piece = new Queen(true);

					} else {
						this.game_board[end.m_rank][end.m_file].piece = new Queen(false);
					}
				} else {

					for (int i = 0; i < promotionPieces.length; i++) {
						if (Promote.equals(promotionPieces[i])) {
							if (promotionPieces[i] == "Q") {
								if (whiteTurn == true) {
									this.game_board[end.m_rank][end.m_file].piece = new Queen(true);

								} else {
									this.game_board[end.m_rank][end.m_file].piece = new Queen(false);
								}
							}

							if (promotionPieces[i] == "B") {
								if (whiteTurn == true) {
									this.game_board[end.m_rank][end.m_file].piece = new Bishop(true);

								} else {
									this.game_board[end.m_rank][end.m_file].piece = new Bishop(false);
								}
							}
							if (promotionPieces[i] == "R") {
								if (whiteTurn == true) {
									this.game_board[end.m_rank][end.m_file].piece = new Rook(true);

								} else {
									this.game_board[end.m_rank][end.m_file].piece = new Rook(false);
								}

							}
							if (promotionPieces[i] == "N") {
								if (whiteTurn == true) {
									this.game_board[end.m_rank][end.m_file].piece = new Knight(true);

								} else {
									this.game_board[end.m_rank][end.m_file].piece = new Knight(false);
								}

							}

						}

					}

				}

				this.game_board[start.m_rank][start.m_file].piece = null;

				checkFlag = this.check();
				if (checkFlag && this.whiteTurn) {
					this.game_board[start.m_rank][start.m_file].piece = backupStart;
					this.game_board[end.m_rank][end.m_file].piece = backupEnd;
					// System.out.println("Black has put itself in check");
					return false;// not valid play so return false
				} else if (checkFlag == true && this.whiteTurn == false) {
					this.game_board[start.m_rank][start.m_file].piece = backupStart;
					this.game_board[end.m_rank][end.m_file].piece = backupEnd;
					// System.out.println("White has put itself in check");
					return false;
				} else {
					allMoves.add(validMove);
					this.turnPicker();

					checkFlag = this.check();// after every move you check on king to see if you put em in check
					if (checkFlag == true && this.whiteTurn == true) {
						//		System.out.println("Check");
					}
					if (checkFlag == true && this.whiteTurn == false) {
						//		System.out.println("Check");
					}

					return true;

				}
			}

			else {// NOT ANY SPECIAL CASE! just a standard play

				Piece backupStart = this.game_board[start.m_rank][start.m_file].piece;
				Piece backupEnd = this.game_board[end.m_rank][end.m_file].piece;

				this.game_board[end.m_rank][end.m_file].piece = this.game_board[start.m_rank][start.m_file].piece;

				this.game_board[start.m_rank][start.m_file].piece = null;

				checkFlag = this.check(); // first do a check to see if this move has resulted in a check for your team
				if (checkFlag == true && this.whiteTurn == true) {
					// System.out.println("White has put itself in check");
					// REVERT BACK TO BOARD BEFORE THE MOVE
					this.game_board[start.m_rank][start.m_file].piece = backupStart;
					this.game_board[end.m_rank][end.m_file].piece = backupEnd;
					return false;// not valid play so return false

				} else if (checkFlag == true && this.whiteTurn == false) {
					this.game_board[start.m_rank][start.m_file].piece = backupStart;
					this.game_board[end.m_rank][end.m_file].piece = backupEnd;
					// System.out.println("Black has put itself in check");
					return false;
				}
				// black moves
				else {
/*
 * Tile startTile = game_board[start.m_rank][start.m_file];

		Tile endTile = game_board[end.m_rank][end.m_file];

		Piece movingPiece = startTile.piece;

		Piece endPiece = endTile.piece;
 *
 *
 */


					allMoves.add(validMove);//should have the original state now not sure tho cause they are addreses
					//store this damn move

					this.turnPicker();// now after this white turn

					checkFlag = this.check();// after every move you check on enemy king to see if you put em in check
					if (checkFlag == true && this.whiteTurn == true) {
						//		System.out.println("Check");
					}
					if (checkFlag == true && this.whiteTurn == false) {
						//		System.out.println("Check");
					}

					return true;

				}
			}
		}

		else {////// IF ITS NOT A VALIDc7 c8 MOVE!!!!!!!!
			return false;
		}

	}



	public boolean undoMove() {

		if(!(allMoves.size()>=1)) {

			//System.out.print("nothing to undo");
			return false;
		}



		Move lastMove=allMoves.get(allMoves.size()-1);

		if(lastMove.movingPiece instanceof Pawn) {//take care of pawn null error
			Pawn p= (Pawn)lastMove.movingPiece;
			if(p.enpassantFlag==true) {
				p.enpassantFlag=false;
				pawnBoardState=false;
			}
		}

		this.game_board[lastMove.endTile.coordinate.m_file][lastMove.endTile.coordinate.m_rank].piece=lastMove.endPiece;
		this.game_board[lastMove.startTile.coordinate.m_file][lastMove.startTile.coordinate.m_rank].piece=lastMove.movingPiece;



		turnPicker();

		return true;

	}


		/*
		 this.game_board[start.m_rank][start.m_file].piece = backupStart;
					this.game_board[end.m_rank][end.m_file].piece = backupEnd;
					return false;// not valid play so return false

				} else if (checkFlag == true && this.whiteTurn == false) {
					this.game_board[start.m_rank][start.m_file].piece = backupStart;
					this.game_board[end.m_rank][end.m_file].piece = backupEnd;
		 */



	/**
	 * this checks to see if there are any pieces in the path of the moving piece
	 *
	 * @param
	 *            start, PairCoordinate end
	 * @return boolean true/false
	 */
	public boolean hasPieceInPath(PairCoordinate start, PairCoordinate end) {
		// DO A SCAN ON ALL DIRECTIONS LEFT RIGHT UP DOWN AND FINALLY ALL DIAGONALS

		if (start.m_file == end.m_file && start.m_rank > end.m_rank) {
			// do a scan to see if any pieces are in its path in its moving direction
			for (int i = start.m_rank - 1; i > end.m_rank; i--) {
				Tile space = game_board[i][start.m_file];
				if (space.isEmpty() == false) {
					return true;
				}
			}
		}

		if (start.m_file == end.m_file && start.m_rank < end.m_rank) {
			// do a scan to see if any pieces are in its path in its moving direction
			for (int i = start.m_rank + 1; i < end.m_rank; i++) {
				Tile space = game_board[i][start.m_file];
				if (space.isEmpty() == false) {
					return true;
				}
			}
		}

		if (start.m_rank == end.m_rank && start.m_file > end.m_file) {
			// do a scan to see if any pieces are in its path in its moving direction
			for (int i = start.m_file - 1; i > end.m_file; i--) {
				Tile space = game_board[start.m_rank][i];
				if (space.isEmpty() == false) {
					return true;
				}
			}
		}

		if (start.m_rank == end.m_rank && start.m_file < end.m_file) {
			// do a scan to see if any pieces are in its path in its moving direction
			for (int i = start.m_file + 1; i < end.m_file; i++) {
				Tile space = game_board[start.m_rank][i];
				if (space.isEmpty() == false) {
					return true;
				}
			}
		}

		if (start.hasDiagPath(end)) {

			int tempFile = start.m_file;
			int tempRank = start.m_rank;

			if (start.m_file < end.m_file && start.m_rank < end.m_rank) {

				while (tempFile + 1 != end.m_file && tempRank + 1 != end.m_rank) {
					if (game_board[tempRank + 1][tempFile + 1].isEmpty() == false) {
						return true;
					}
					tempFile += 1;
					tempRank += 1;
				}

			}

			if (start.m_file > end.m_file && start.m_rank > end.m_rank) {

				while (tempFile - 1 != end.m_file && tempRank - 1 != end.m_rank) {
					if (game_board[tempRank - 1][tempFile - 1].isEmpty() == false) {
						return true;
					}

					tempFile -= 1;
					tempRank -= 1;
				}

			}

			if (start.m_file < end.m_file && start.m_rank > end.m_rank) {

				while (tempFile + 1 != end.m_file && tempRank - 1 != end.m_rank) {
					if (game_board[tempRank - 1][tempFile + 1].isEmpty() == false) {
						return true;
					}

					tempFile += 1;
					tempRank -= 1;

				}

			}

			if (start.m_file > end.m_file && start.m_rank < end.m_rank) {// d0 a3 stuck in here

				while (tempFile - 1 != end.m_file && tempRank + 1 != end.m_rank) {
					if (game_board[tempRank + 1][tempFile - 1].isEmpty() == false) {
						return true;
					}
					tempFile -= 1;
					tempRank += 1;
				}

			}

		}

		return false;

	}

	/**
	 * to copy the board
	 *
	 * @param
	 * @return board type, copyBoard
	 */
	// @SuppressWarnings("null")
	public Board copyBoard() {

		Board copyBoard = new Board();
		copyBoard.checkFlag = this.checkFlag;
		copyBoard.whiteTurn = this.whiteTurn;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (game_board[i][j].piece instanceof Rook) {
					Rook realRook = (Rook) game_board[i][j].piece;
					Rook copyRook = new Rook(true);
					copyRook.color = realRook.color;
					copyRook.type = realRook.type;
					copyRook.isFirstMove = realRook.isFirstMove;
					copyBoard.game_board[i][j] = new Tile(this.game_board[i][j].coordinate, copyRook);
				} else {
					copyBoard.game_board[i][j] = new Tile(this.game_board[i][j].coordinate,
							this.game_board[i][j].piece);
				}
			}
		}

		return copyBoard;

	}

	/**
	 * Overrides the toString Method
	 *
	 * @param
	 * @return String the rank alphabets for the player to see where each piece is
	 */
	public String toString() {
		String str = "";
		int count = 8;
		for (int i = 0; i < game_board.length; i++) {
			for (int j = 0; j < game_board[i].length; j++) {
				// str += this.game_board[i][j].toString() + " "; //one tile

				str += this.game_board[i][j].toString() + " ";

				// System.out.print("hate");
			}

			str += "" + count + "\n";
			count--;// this is to generate rank number on the side
		}

		str += " a  b  c  d  e  f  g  h";

		return str;
	}

}
