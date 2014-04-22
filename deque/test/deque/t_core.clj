(ns deque.t-core
  (:use midje.sweet)
  (:use [deque.core])
  (:import [deque.core Deque] ))

(facts "about this lab"
  (fact "the student never started it."
        (+ 1 2)  => 3))



(facts "about 'deque-size'"
       (let [test_deque (Deque. '(1 2 3 4 5 6) '(7 8) 8)
             test_deque2 (Deque. '(5 8 9 10) '(1 2) 6)]
         (fact "it returns deque size"
               (deque-size test_deque) => 8
               (deque-size test_deque2) => 6)))

(facts "about 'push-front'"
       (let [test_deque (Deque. '(1 2 3 4 5 6) '(7 8) 8)
             test_deque2 (Deque. '(5 8 9 10) '(1 2) 6)]
         (fact "it increments size properly"
               (:size (push-front test_deque 8)) => 9
               (:size (push-front test_deque2 10)) => 7)))

(facts "about 'push-back'"
       (let [test_deque (Deque. '(1 2 3 4 5 6) '(7 8) 8)
             test_deque2 (Deque. '(5 8 9 10) '(1 2) 6)]
         (fact "it inserts element properly"
               (:back (push-back test_deque 8)) => '(8 7 8)
               (:back (push-back test_deque2 10)) => '(10 1 2))))


(facts "about 'flip-front'"
       (let [test_deque (Deque. '() '(7 8) 8)
             test_deque2 (Deque. '() '(1 2) 6)
             test_deque3 (Deque. '(1 2 3) '(4 5 6) 6)
             test_deque4 (Deque. '(5 3 4 5 3 2) '(1 4 3 58 9) 11)]
         (fact "it clears the back"
               (:back (flip-front test_deque)) => '()
               (:back (flip-front test_deque2)) => '() )

         (fact "does not always flip"
               (:back (flip-front test_deque3)) => '(4 5 6)
               (:back (flip-front test_deque4)) => '(1 4 3 58 9) )))

(facts "about 'flip-back'"
       (let [test_deque (Deque. '(7 8) '() 8)
             test_deque2 (Deque. '(1 2) '() 6)]
         (fact "it clears the front"
               (:front (flip-back test_deque)) => '()
               (:front (flip-back  test_deque2)) => '() )))


(facts "about 'back'"
       (let [test_deque (Deque. '(7 8) '() 8)
             test_deque2 (Deque. '(1 2) '() 6)]
         (fact "back flips list"
               (back test_deque) => 8
               (back test_deque2) => 2)))

(facts "about 'front'"
       (let [test_deque (Deque. '(7 8 9 10) '(1 2 3 5) 8)
             test_deque2 (Deque. '(1 2) '(23 3 4 23 32) 6)]
         (fact "first does not reference back list"
               (front test_deque) => 7
               (front test_deque2) => 1)))

(facts "about 'pop-back'"
       (let [test_deque (Deque. '(1 2 3 4 5 6) '(7 8) 8)
             test_deque2 (Deque. '(5 8 9 10) '(1 2) 6)
             test_deque3 (Deque. '() '() 0)]
         (fact "it decrements size properly"
               (:size (pop-back test_deque)) => 7
               (:size (pop-back test_deque2)) => 5
               (:size (pop-back test_deque3)) => 0)))

(facts "about 'pop-front'"
       (let [test_deque (Deque. '(1 2 3 4 5 6) '(7 8) 8)
             test_deque2 (Deque. '(5 8 9 10) '(1 2) 6)
             test_deque3 (Deque. '() '() 0)]
         (fact "it decrements size properly"
               (:size (pop-front test_deque)) => 7
               (:size (pop-front test_deque2)) => 5
               (:size (pop-front test_deque3)) => 0)))