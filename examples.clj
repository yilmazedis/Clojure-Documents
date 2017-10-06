(ns clojure.examples.example
   (:require [clojure.set :as set])
   (require [clojure.string :as str])
   
   (:gen-class))

(defn readFile [name]
  (clojure.string/split (slurp name) #"\s+"))
 
 (defn mkList [vect]
  ;(println vect)
	(def reverseVect (reverse vect)) ; reverse vector
	(def newList (list)) ; Decleration empty list
	(def sizeVect (count vect)) ; vector size
	(dotimes [n sizeVect] ; Loop statement
		(def elemVect (nth reverseVect n)) ; get element of vector
		(def letters (apply list elemVect)) ; convert vector to list
		(def newList (cons letters newList))) ; add list to begining of list

	(let [] newList)
)

;(println (mkList (readFile "document1.txt")))
;(println (mkList (readFile "dictionary1.txt")))

(defn matchWords [w1 w2]
  (def matched 0)
  (def len_w1 (count w1))
  (def len_w2 (count w2))
  (dotimes [n1 len_w1]
      (dotimes [n2 len_w2]
          (if (= (nth w1 n1) (nth w2 n2)) (def matched (inc matched)))))
  (let [] matched))


(println (matchWords (mkList (readFile "document2.txt")) (mkList (readFile "dictionary1.txt"))))

(defn ints-from [n]
  (cons n (lazy-seq (ints-from (dec n)))))

(println (take 10 (ints-from 7)))


(defn rotations [a-seq]
  (map concat (tails a-seq) (inits a-seq)))


(rotations (range 5))





