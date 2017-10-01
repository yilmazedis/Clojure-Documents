(ns clojure.examples.hello
   (:gen-class))
 
 (import java.util.ArrayList)

(defn lines []
   (with-open [rdr (clojure.java.io/reader "dictionary1.txt")]
   (reduce conj [] (line-seq rdr))))
 
 ;(println (nth (clojure.string/split (nth (lines) 0) #" ") 2))
 ;(def x (clojure.string/split (nth (lines) 0) #" "))
 ;(println (count x))
 
 (defn TraceWords []
   
   (println (.charAt "yilmaz" 3))
   (println (.toString 23234))
   (println (java.util.ArrayList. (lines
                                    )))
   
   (def words (lines))
   (def wordNum (count words))
   ;(println wordNum)
   (dotimes [n wordNum]
   (def singleLine (clojure.string/split (nth words n) #" "))
   
   (def totalWord (count singleLine))
   (println "\nline size --->>>> " totalWord)
   (dotimes [nm totalWord]
   (def newWord (clojure.string/split (nth singleLine nm) #" "))
   
   (println newWord))))
 
 (TraceWords)
 
 ;(defn examp []
  ;(clojure.string/split "hello\ndfsdf"  #"\n"))

;(println (examp))
