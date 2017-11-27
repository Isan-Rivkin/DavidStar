# DavidStar
Implemented Algorithm for solving a given cipher using mathematical equations system. 

/**
Algorithm Definition:
give:
- Set of equations.
- Bank = the numbers to work with in order to fill the equations.
result:
- First Combination from the Bank of Numbers that solves the equations.

How:
The algorithms checks all the combinations with heuristic.
It stops at the first result and do not actually go over all the options.
The algorithms has 2 states A and B.
State A:
given a callback - find all combinations that support the callback 
State B:
Incase A is True try a combination with B 

Input/Output:

- init = public void init(IValidator validator, CombinationsCreator combinator, PermutationsCreator permutator);-
- validator = holds all the equations and evaluates a given orderd input of combination
- input =  public Combination decipher(Func a_predicate,Bank initial_bank,int a_len)
- a_predicate = callback to filter results

Pseudo-Code:

A = allPermutations(initial_bank,a_predicate)
while not found:
  foreach a_permutation in A:
    b_permutation = (initial_bank - a_permutation)
    list_a_combinations = allCombinations(a_permutation)
    list_b_combinations = allCombinations(b_permutation)
    foreach a in list_a_combinations:
      foreach b in list_b_combinations
        found = validateEquations(a,b)
        if(found)
          return combination(a,b)
  return null        
  
*/
