// Generated from XPR.g4 by ANTLR 4.5.1
package z3fol.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPRLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LPAREN=4, RPAREN=5, LBRACKET=6, RBRACKET=7, PLUS=8, 
		MINUS=9, TIMES=10, DIV=11, GT=12, GE=13, LE=14, LT=15, EQ=16, NEQ=17, 
		ASSIGN=18, POINT=19, POW=20, OR=21, AND=22, IMPLIES=23, IFF=24, XOR=25, 
		NOT=26, SEMICOLON=27, SET_IN=28, SET_NOTIN=29, SET_UNION=30, SET_INTERSECT=31, 
		SET_DIFF=32, EXISTS=33, FORALL=34, KWD_TYPE=35, KWD_DECLARE=36, KWD_ASSERT=37, 
		KWD_TRUE=38, KWD_FALSE=39, NUM_DECIMAL=40, IDENTIFIER_UC=41, IDENTIFIER_LC=42, 
		Whitespace=43, Newline=44, BlockComment=45, LineComment=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "PLUS", 
		"MINUS", "TIMES", "DIV", "GT", "GE", "LE", "LT", "EQ", "NEQ", "ASSIGN", 
		"POINT", "POW", "OR", "AND", "IMPLIES", "IFF", "XOR", "NOT", "SEMICOLON", 
		"SET_IN", "SET_NOTIN", "SET_UNION", "SET_INTERSECT", "SET_DIFF", "EXISTS", 
		"FORALL", "KWD_TYPE", "KWD_DECLARE", "KWD_ASSERT", "KWD_TRUE", "KWD_FALSE", 
		"NUM_DECIMAL", "IDENTIFIER_UC", "IDENTIFIER_LC", "Whitespace", "Newline", 
		"BlockComment", "LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'0'", "','", "':'", "'('", "')'", "'{'", "'}'", "'+'", "'-'", "'*'", 
		"'/'", "'>'", "'>='", "'<='", "'<'", "'=='", "'!='", "':='", "'.'", "'^'", 
		"'|'", "'&'", "'=>'", "'<=>'", "'XOR'", "'!'", "';'", "'in'", "'notin'", 
		"'∪'", "'∩'", "'\\'", "'Exists'", "'Forall'", "'type'", "'declare'", "'assert'", 
		"'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "PLUS", 
		"MINUS", "TIMES", "DIV", "GT", "GE", "LE", "LT", "EQ", "NEQ", "ASSIGN", 
		"POINT", "POW", "OR", "AND", "IMPLIES", "IFF", "XOR", "NOT", "SEMICOLON", 
		"SET_IN", "SET_NOTIN", "SET_UNION", "SET_INTERSECT", "SET_DIFF", "EXISTS", 
		"FORALL", "KWD_TYPE", "KWD_DECLARE", "KWD_ASSERT", "KWD_TRUE", "KWD_FALSE", 
		"NUM_DECIMAL", "IDENTIFIER_UC", "IDENTIFIER_LC", "Whitespace", "Newline", 
		"BlockComment", "LineComment"
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


	public XPRLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XPR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0117\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&"+
		"\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\6)\u00dd\n)\r)\16"+
		")\u00de\3*\3*\7*\u00e3\n*\f*\16*\u00e6\13*\3+\3+\7+\u00ea\n+\f+\16+\u00ed"+
		"\13+\3,\6,\u00f0\n,\r,\16,\u00f1\3,\3,\3-\3-\5-\u00f8\n-\3-\5-\u00fb\n"+
		"-\3-\3-\3.\3.\3.\3.\7.\u0103\n.\f.\16.\u0106\13.\3.\3.\3.\3.\3.\3/\3/"+
		"\3/\3/\7/\u0111\n/\f/\16/\u0114\13/\3/\3/\3\u0104\2\60\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60\3\2\b\3\2\62;\4\2C\\aa\6\2\62;C\\aac|\4\2aac|\4"+
		"\2\13\13\"\"\4\2\f\f\17\17\u011e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2\2\13g\3\2\2"+
		"\2\ri\3\2\2\2\17k\3\2\2\2\21m\3\2\2\2\23o\3\2\2\2\25q\3\2\2\2\27s\3\2"+
		"\2\2\31u\3\2\2\2\33w\3\2\2\2\35z\3\2\2\2\37}\3\2\2\2!\177\3\2\2\2#\u0082"+
		"\3\2\2\2%\u0085\3\2\2\2\'\u0088\3\2\2\2)\u008a\3\2\2\2+\u008c\3\2\2\2"+
		"-\u008e\3\2\2\2/\u0090\3\2\2\2\61\u0093\3\2\2\2\63\u0097\3\2\2\2\65\u009b"+
		"\3\2\2\2\67\u009d\3\2\2\29\u009f\3\2\2\2;\u00a2\3\2\2\2=\u00a8\3\2\2\2"+
		"?\u00aa\3\2\2\2A\u00ac\3\2\2\2C\u00ae\3\2\2\2E\u00b5\3\2\2\2G\u00bc\3"+
		"\2\2\2I\u00c1\3\2\2\2K\u00c9\3\2\2\2M\u00d0\3\2\2\2O\u00d5\3\2\2\2Q\u00dc"+
		"\3\2\2\2S\u00e0\3\2\2\2U\u00e7\3\2\2\2W\u00ef\3\2\2\2Y\u00fa\3\2\2\2["+
		"\u00fe\3\2\2\2]\u010c\3\2\2\2_`\7\62\2\2`\4\3\2\2\2ab\7.\2\2b\6\3\2\2"+
		"\2cd\7<\2\2d\b\3\2\2\2ef\7*\2\2f\n\3\2\2\2gh\7+\2\2h\f\3\2\2\2ij\7}\2"+
		"\2j\16\3\2\2\2kl\7\177\2\2l\20\3\2\2\2mn\7-\2\2n\22\3\2\2\2op\7/\2\2p"+
		"\24\3\2\2\2qr\7,\2\2r\26\3\2\2\2st\7\61\2\2t\30\3\2\2\2uv\7@\2\2v\32\3"+
		"\2\2\2wx\7@\2\2xy\7?\2\2y\34\3\2\2\2z{\7>\2\2{|\7?\2\2|\36\3\2\2\2}~\7"+
		">\2\2~ \3\2\2\2\177\u0080\7?\2\2\u0080\u0081\7?\2\2\u0081\"\3\2\2\2\u0082"+
		"\u0083\7#\2\2\u0083\u0084\7?\2\2\u0084$\3\2\2\2\u0085\u0086\7<\2\2\u0086"+
		"\u0087\7?\2\2\u0087&\3\2\2\2\u0088\u0089\7\60\2\2\u0089(\3\2\2\2\u008a"+
		"\u008b\7`\2\2\u008b*\3\2\2\2\u008c\u008d\7~\2\2\u008d,\3\2\2\2\u008e\u008f"+
		"\7(\2\2\u008f.\3\2\2\2\u0090\u0091\7?\2\2\u0091\u0092\7@\2\2\u0092\60"+
		"\3\2\2\2\u0093\u0094\7>\2\2\u0094\u0095\7?\2\2\u0095\u0096\7@\2\2\u0096"+
		"\62\3\2\2\2\u0097\u0098\7Z\2\2\u0098\u0099\7Q\2\2\u0099\u009a\7T\2\2\u009a"+
		"\64\3\2\2\2\u009b\u009c\7#\2\2\u009c\66\3\2\2\2\u009d\u009e\7=\2\2\u009e"+
		"8\3\2\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1:\3\2\2\2\u00a2\u00a3"+
		"\7p\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7k\2\2\u00a6"+
		"\u00a7\7p\2\2\u00a7<\3\2\2\2\u00a8\u00a9\7\u222c\2\2\u00a9>\3\2\2\2\u00aa"+
		"\u00ab\7\u222b\2\2\u00ab@\3\2\2\2\u00ac\u00ad\7^\2\2\u00adB\3\2\2\2\u00ae"+
		"\u00af\7G\2\2\u00af\u00b0\7z\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7u\2\2"+
		"\u00b2\u00b3\7v\2\2\u00b3\u00b4\7u\2\2\u00b4D\3\2\2\2\u00b5\u00b6\7H\2"+
		"\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba"+
		"\7n\2\2\u00ba\u00bb\7n\2\2\u00bbF\3\2\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be"+
		"\7{\2\2\u00be\u00bf\7r\2\2\u00bf\u00c0\7g\2\2\u00c0H\3\2\2\2\u00c1\u00c2"+
		"\7f\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5\7n\2\2\u00c5"+
		"\u00c6\7c\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7g\2\2\u00c8J\3\2\2\2\u00c9"+
		"\u00ca\7c\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7g\2\2"+
		"\u00cd\u00ce\7t\2\2\u00ce\u00cf\7v\2\2\u00cfL\3\2\2\2\u00d0\u00d1\7v\2"+
		"\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7w\2\2\u00d3\u00d4\7g\2\2\u00d4N\3\2"+
		"\2\2\u00d5\u00d6\7h\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9"+
		"\7u\2\2\u00d9\u00da\7g\2\2\u00daP\3\2\2\2\u00db\u00dd\t\2\2\2\u00dc\u00db"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"R\3\2\2\2\u00e0\u00e4\t\3\2\2\u00e1\u00e3\t\4\2\2\u00e2\u00e1\3\2\2\2"+
		"\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5T\3"+
		"\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00eb\t\5\2\2\u00e8\u00ea\t\4\2\2\u00e9"+
		"\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ecV\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f0\t\6\2\2\u00ef\u00ee"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\b,\2\2\u00f4X\3\2\2\2\u00f5\u00f7\7\17\2\2"+
		"\u00f6\u00f8\7\f\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fb"+
		"\3\2\2\2\u00f9\u00fb\7\f\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\b-\2\2\u00fdZ\3\2\2\2\u00fe\u00ff\7\61\2\2"+
		"\u00ff\u0100\7,\2\2\u0100\u0104\3\2\2\2\u0101\u0103\13\2\2\2\u0102\u0101"+
		"\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105"+
		"\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\7,\2\2\u0108\u0109\7\61"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\u010b\b.\2\2\u010b\\\3\2\2\2\u010c\u010d"+
		"\7\61\2\2\u010d\u010e\7\61\2\2\u010e\u0112\3\2\2\2\u010f\u0111\n\7\2\2"+
		"\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\b/\2\2\u0116"+
		"^\3\2\2\2\13\2\u00de\u00e4\u00eb\u00f1\u00f7\u00fa\u0104\u0112\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}