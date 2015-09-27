# Z3XPR
[Z3](https://github.com/Z3Prover/z3) is a SAT solver developed by [Microsoft Research](https://z3.codeplex.com/). 
Z3XPR adds a nice mathematical syntax over the Java bindings for Z3. 
It allows you to quickly generate Z3 expressions ([Expr](https://github.com/Z3Prover/z3/blob/master/src/api/java/Expr.java)), types ([Sort](https://github.com/Z3Prover/z3/blob/master/src/api/java/Sort.java)) and predicates ([BoolExpr](https://github.com/Z3Prover/z3/blob/master/src/api/java/BoolExpr.java)).

Example:

    State s = new State();
    List<BoolExpr> statements = Processor.process("Exists Int x: x > 0;");
    Status result = Z3Utils.check(statements);
    // result == Status.SATISFIABLE

Z3XPR can parse multiline expressions:

    State s = new State();
    Status result = Z3Utils.check(Processor.process(
        "Set{} set;",
        "Forall Int x: x in set => x > 5;",
        "Exists Int x: x in set & x < 4;"
    ));
    // result == Status.UNSATISFIABLE
    
The grammar is defined here: https://github.com/Eipifi/Z3XPR/blob/master/src/main/java/z3fol/antlr/XPR.g4