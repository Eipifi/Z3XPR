// Generated from Lispy.g4 by ANTLR 4.5.1
package eipifi.lispy.lang;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LispyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, Whitespace=3, Newline=4, BlockComment=5, LineComment=6, 
		ATOM=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "Whitespace", "Newline", "BlockComment", "LineComment", 
		"ATOM"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "Whitespace", "Newline", "BlockComment", "LineComment", 
		"ATOM"
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


	public LispyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lispy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tC\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\4\6\4"+
		"\27\n\4\r\4\16\4\30\3\4\3\4\3\5\3\5\5\5\37\n\5\3\5\5\5\"\n\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\7\6*\n\6\f\6\16\6-\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\7\78\n\7\f\7\16\7;\13\7\3\7\3\7\3\b\6\b@\n\b\r\b\16\bA\3+\2\t\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5\4\2\13\13\"\"\4\2\f\f\17\17\5\2\62;C"+
		"\\c|H\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\23\3\2\2\2\7\26\3\2\2\2\t!\3\2\2"+
		"\2\13%\3\2\2\2\r\63\3\2\2\2\17?\3\2\2\2\21\22\7*\2\2\22\4\3\2\2\2\23\24"+
		"\7+\2\2\24\6\3\2\2\2\25\27\t\2\2\2\26\25\3\2\2\2\27\30\3\2\2\2\30\26\3"+
		"\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32\33\b\4\2\2\33\b\3\2\2\2\34\36\7"+
		"\17\2\2\35\37\7\f\2\2\36\35\3\2\2\2\36\37\3\2\2\2\37\"\3\2\2\2 \"\7\f"+
		"\2\2!\34\3\2\2\2! \3\2\2\2\"#\3\2\2\2#$\b\5\2\2$\n\3\2\2\2%&\7\61\2\2"+
		"&\'\7,\2\2\'+\3\2\2\2(*\13\2\2\2)(\3\2\2\2*-\3\2\2\2+,\3\2\2\2+)\3\2\2"+
		"\2,.\3\2\2\2-+\3\2\2\2./\7,\2\2/\60\7\61\2\2\60\61\3\2\2\2\61\62\b\6\2"+
		"\2\62\f\3\2\2\2\63\64\7\61\2\2\64\65\7\61\2\2\659\3\2\2\2\668\n\3\2\2"+
		"\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\b"+
		"\7\2\2=\16\3\2\2\2>@\t\4\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B"+
		"\20\3\2\2\2\t\2\30\36!+9A\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}