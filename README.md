# Z3XPR
[Z3](https://github.com/Z3Prover/z3) is a SAT solver developed by [Microsoft Research](https://z3.codeplex.com/). 
Z3XPR adds a nice mathematical syntax over the Java bindings for Z3. 
It allows you to quickly generate Z3 expressions ([Expr](https://github.com/Z3Prover/z3/blob/master/src/api/java/Expr.java)), types ([Sort](https://github.com/Z3Prover/z3/blob/master/src/api/java/Sort.java)) and predicates ([BoolExpr](https://github.com/Z3Prover/z3/blob/master/src/api/java/BoolExpr.java)).

Example:

```java
    State s = new State();
    Processor.process(s, 
        // declare sets
        "Int{} aSet;",                  
        // declare variables
        "Int foobar := 5;",            
        // define new types of variables
        "type MyType;",                 
        // perform simple math operations
        "Int someMath := 2 + 2 * 2;",   
        // set operations are also supported
        "Int{} newSet := aSet ∪ {1, 2, 3} ∩ {1, 3, 5};"                 
    );
    // Now you can access the expressions as Z3 objects
    Expr mathExpr = s.getExpr("someMath");
```

Z3XPR can use Z3 to prove satisfiability of expressions:

```java
    State s = new State();
    List<BoolExpr> statements = Processor.process(s, "Exists Int x: x > 0;");
    Status result = Z3Utils.check(statements);
    // result == Status.SATISFIABLE
```

Z3XPR can parse multiline expressions:

```java
    State s = new State();
    Status result = Z3Utils.check(Processor.process(s, 
        "Set{} set;",
        "Forall Int x: x in set => x > 5;",
        "Exists Int x: x in set & x < 4;"
    ));
    // result == Status.UNSATISFIABLE
```    
    
The grammar is defined here: https://github.com/Eipifi/Z3XPR/blob/master/src/main/java/z3fol/antlr/XPR.g4