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


Some of the XPR syntax rules:

```
// Double slash to place comments

// Expressions end with a semicolon
; 

// You can define new types (a.k.a. uninterpreted sort).
// All types have an uppercase first letter.
type Foobar;

// You can also alias existing types.
type MyInt Int;

// You can define tuple types.
type Vector3D (Int, Int, Int);

// Variables always have a lowercase first letter.
Int anInt;

// You can assign a value to a variable, or leave it unspecified.
// Assign values by using the := operator.
Int anotherInt := 42;

// Tuples can be created with the following syntax:
Vector3D up := Vector3D(0, 0, 1);

// Fields of a tuple can be accessed using the field number, starting from 0.
Int upValue := up.2;

// Sets of any value can be defined by adding a curly bracket.
Int{} myIntegers;

// An inline value of a set can be created the following way:
Int{} theNumbers := {4, 8, 15, 16, 23, 42};

// Each type has a defined type for its elements.
// To define an empty set, prefix the bracket with the type identifier.
Int{} emptySet := Int{};

// Set operators:
Int{} sum := {1, 2, 3, 4} ∪ {3, 4, 5, 6}; // {1, 2, 3, 4, 5, 6}
Int{} mul := {1, 2, 3, 4} ∩ {3, 4, 5, 6}; // {3, 4}
Int{} dif := {1, 2, 3, 4} \ {3, 4, 5, 6}; // {1, 2}

// Elements can be checked for membership in a set:
Bool isInside := 5 in {1, 3, 5, 7};

// Subset checking is also available:
Bool inSubset := {1, 2} ⊂ {1, 2, 3, 4};

// Logic operations:
Bool a;
Bool b;
Bool c;

a | b;      // OR
a & b;      // AND
!a;         // negation
a => b;     // implication
a <=> b;    // IFF
a XOR b;    // XOR

// All expressions can be compared:

2 + 2 * 2 == 6;
(2 + 2) * 2 == 8;
pi != 3;

// Logic operations can be prefixed with quantifiers:
Forall Int x: x > 0 => x > 5;
Exists Int x: x + 1 == 20;

// Tuples can also be used this way:

type ID;
type Balance Int;
type Account (ID, Balance);
Account{} accounts;
Forall Account a, Account b: (a in accounts & b in accounts) => a.0 != b.0;




```
