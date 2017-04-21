;;Se utiliza la un tablero de 7x6. 6 listas de 7 elementos cada una.
(setq tablero
      '(
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        )
)
;; funcion que hace un movimiento con el tablero actual, el indice donde entra la nueva ficha y que 'jugador' tira.
;;params: tablero, indice [0-6], player
(defun f_makeMove (thisTablero index player)
  (setq newTablero (copy-list thisTablero))
  (dotimes (n 6)
       (cond
        ((= (nth index (nth (- 5 n) newTablero)) 0)
         (setq row (copy-list (nth (- 5 n) newTablero)))
         (setf (nth index row) player)
         (setf (nth (- 5 n) newTablero) row)
         ;;(f_beautyPrint newTablero)
         (return-from f_makeMove newTablero)
         )
       )
   )
  (return-from f_makeMove '())
)

;;Imprime un tablero de forma ordenada. 
(defun f_beautyPrint (thisTablero)
  (dotimes (n 6)
    (print (nth n thisTablero))
  )
)
