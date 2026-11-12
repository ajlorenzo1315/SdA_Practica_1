#!/usr/bin/env python3
"""Verificación básica de CSP sin dependencias de terceros."""
import re
import sys
import urllib.request
from html.parser import HTMLParser

class Scripts(HTMLParser):
    def __init__(self):
        super().__init__()
        self.nonces = []
    def handle_starttag(self, tag, attrs):
        if tag.lower() == 'script':
            self.nonces.append(dict(attrs).get('nonce'))

def fetch(url):
    with urllib.request.urlopen(url, timeout=15) as response:
        return response.headers, response.read().decode('utf-8', 'replace')

def check(ok, message):
    print(('OK' if ok else 'FALLO') + ': ' + message)
    return ok

def main(url):
    h1, body1 = fetch(url)
    h2, _ = fetch(url)
    c1 = h1.get('Content-Security-Policy', '')
    c2 = h2.get('Content-Security-Policy', '')
    n1 = re.search(r"'nonce-([^']+)'", c1)
    n2 = re.search(r"'nonce-([^']+)'", c2)
    directives = {part.strip().split(' ', 1)[0]: part.strip() for part in c1.split(';') if part.strip()}
    parser = Scripts()
    parser.feed(body1)
    results = [
        check(bool(c1), 'CSP presente'),
        check(directives.get('default-src') == "default-src 'none'", 'denegacion por defecto'),
        check("'unsafe-inline'" not in directives.get('script-src', ''), 'scripts sin unsafe-inline'),
        check("'unsafe-eval'" not in directives.get('script-src', ''), 'scripts sin unsafe-eval'),
        check(directives.get('script-src-attr') == "script-src-attr 'none'", 'atributos de evento bloqueados'),
        check(directives.get('frame-ancestors') == "frame-ancestors 'none'", 'clickjacking bloqueado'),
        check(bool(n1 and n2 and n1.group(1) != n2.group(1)), 'nonce distinto en dos respuestas'),
        check(bool(n1 and all(n == n1.group(1) for n in parser.nonces)), 'todos los scripts tienen nonce correcto'),
        check(h1.get('X-Frame-Options') == 'DENY', 'X-Frame-Options DENY'),
    ]
    print(f'Scripts HTML encontrados: {len(parser.nonces)}')
    return 0 if all(results) else 1

if __name__ == '__main__':
    sys.exit(main(sys.argv[1] if len(sys.argv) > 1 else 'http://localhost:8888/'))
