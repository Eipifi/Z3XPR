// Generated from FOL.g4 by ANTLR 4.5.1
package z3fol.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LPAREN=2, RPAREN=3, AND=4, OR=5, NOT=6, COLON=7, FORALL=8, EXISTS=9, 
		VARIABLE=10, CONSTANT=11, PREPOSITION=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "LPAREN", "RPAREN", "AND", "OR", "NOT", "COLON", "FORALL", "EXISTS", 
		"VARIABLE", "CONSTANT", "PREPOSITION", "CHARACTER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "')'", "'&'", "'|'", "'!'", "':'", "'Forall'", "'Exists'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LPAREN", "RPAREN", "AND", "OR", "NOT", "COLON", "FORALL", 
		"EXISTS", "VARIABLE", "CONSTANT", "PREPOSITION", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public FOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17^\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\5\13>\n\13\3\13\7\13A\n\13\f\13\16\13D\13\13\3"+
		"\f\5\fG\n\f\3\f\7\fJ\n\f\f\f\16\fM\13\f\3\r\3\r\7\rQ\n\r\f\r\16\rT\13"+
		"\r\3\16\3\16\3\17\6\17Y\n\17\r\17\16\17Z\3\17\3\17\2\2\20\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\2\35\17\3\2\5\4\2\62"+
		";c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"`\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\35\3\2\2\2\3\37\3"+
		"\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17+\3"+
		"\2\2\2\21-\3\2\2\2\23\64\3\2\2\2\25;\3\2\2\2\27F\3\2\2\2\31N\3\2\2\2\33"+
		"U\3\2\2\2\35X\3\2\2\2\37 \7.\2\2 \4\3\2\2\2!\"\7*\2\2\"\6\3\2\2\2#$\7"+
		"+\2\2$\b\3\2\2\2%&\7(\2\2&\n\3\2\2\2\'(\7~\2\2(\f\3\2\2\2)*\7#\2\2*\16"+
		"\3\2\2\2+,\7<\2\2,\20\3\2\2\2-.\7H\2\2./\7q\2\2/\60\7t\2\2\60\61\7c\2"+
		"\2\61\62\7n\2\2\62\63\7n\2\2\63\22\3\2\2\2\64\65\7G\2\2\65\66\7z\2\2\66"+
		"\67\7k\2\2\678\7u\2\289\7v\2\29:\7u\2\2:\24\3\2\2\2;=\7A\2\2<>\t\2\2\2"+
		"=<\3\2\2\2>B\3\2\2\2?A\5\33\16\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2"+
		"\2C\26\3\2\2\2DB\3\2\2\2EG\t\2\2\2FE\3\2\2\2GK\3\2\2\2HJ\5\33\16\2IH\3"+
		"\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\30\3\2\2\2MK\3\2\2\2NR\4C\\\2OQ"+
		"\5\33\16\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\32\3\2\2\2TR\3\2\2"+
		"\2UV\t\3\2\2V\34\3\2\2\2WY\t\4\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2"+
		"\2\2[\\\3\2\2\2\\]\b\17\2\2]\36\3\2\2\2\t\2=BFKRZ\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}