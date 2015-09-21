package uber;

/*
 * http://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
 */

public class TinyURL {
    class Solution {
	public String idToURL(long n) {
	    char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	    StringBuilder res = new StringBuilder();
	    while (n > 0) {
		res.append(map[(int) (n % 62)]);
		n /= 62;
	    }

	    return res.reverse().toString();
	}
    }

    long urlToID(String url) {
	long res = 0;
	for (int i = 0; i < url.length(); i++) {
	    char c = url.charAt(i);
	    int val = 0;
	    if (c >= 'a' && c <= 'z') {
		val = (int) (c - 'a');
	    } else if (c >= 'A' && c <= 'Z') {
		val = 26 + (int) (c - 'A');
	    } else {
		val = 52 + (int) (c - '0');
	    }

	    res = res * 62 + val;
	}

	return res;
    }
}

//
////Function to generate a short url from intger ID
//string idToShortURL(long int n)
//{
// // Map to store 62 possible characters
// char map[] = "abcdefghijklmnopqrstuvwxyzABCDEF"
//              "GHIJKLMNOPQRSTUVWXYZ0123456789";
//
// string shorturl;
//
// // Convert given integer id to a base 62 number
// while (n)
// {
//     // use above map to store actual character
//     // in short url
//     shorturl.push_back(map[n%62]);
//     n = n/62;
// }
//
// // Reverse shortURL to complete base conversion
// reverse(shorturl.begin(), shorturl.end());
//
// return shorturl;
//}
//
////Function to get integer ID back from a short url
//long int shortURLtoID(string shortURL)
//{
// long int id = 0; // initialize result
//
// // A simple base conversion logic
// for (int i=0; i < shortURL.length(); i++)
// {
//     if ('a' <= shortURL[i] && shortURL[i] <= 'z')
//       id = id*62 + shortURL[i] - 'a';
//     if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
//       id = id*62 + shortURL[i] - 'A' + 26;
//     if ('0' <= shortURL[i] && shortURL[i] <= '9')
//       id = id*62 + shortURL[i] - '0' + 52;
// }
// return id;
//}