import java.util.*;
import java.util.stream.Collectors;

public class Alphabet {



    private static final String ruString =  "а, б, в, г, д, е, ё, ж, з, и, й, к, л, м, н, о, п, р, с, т, у, ф, х, ц, ч, ш, щ, ъ, ы, ь, э, ю, я, (, ., ,, \", :, -, !, ?,  ";

    public static char[] ru = ruString.replaceAll(", ", "").toCharArray();

    private static final String engString =  "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, (, ., ,, \", :, -, !, ?,  ";

    public static char[] eng = engString.replaceAll(", ", "").toCharArray();



    private Alphabet () {


}}
