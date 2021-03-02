" ~/neovim/plugged is where the plugins are
" getting installed
" Plugin section starts
" -------------------------------------------
call plug#begin('~/neovim/plugged')
" On-demand loading
Plug 'scrooloose/nerdtree', { 'on':  'NERDTreeToggle' }

" plugin provides mappings to easily delete, change
" and add such surroundings in pairs.
" --------------------
Plug 'tpope/vim-surround'
Plug '~/projects/vim-python-magic'
Plug 'tomasiser/vim-code-dark'
Plug 'sbdchd/neoformat'
Plug 'tpope/vim-markdown'
Plug 'dense-analysis/ale'
Plug 'joshdick/onedark.vim'
Plug 'rmagatti/auto-session'
Plug 'luochen1990/rainbow'
Plug 'nathanaelkane/vim-indent-guides'
Plug 'nvim-treesitter/nvim-treesitter', {'do': ':TSUpdate'}
Plug 'norcalli/nvim-colorizer.lua'
" Mulitple cursors
" ------------------
Plug 'mg979/vim-visual-multi', {'branch': 'master'}

call plug#end()
" Plugin section ends here
" ------------------

" Other settings go here
" ------------------
" A high-performance color highlighter for Neovim

colorscheme onedark
set termguicolors t_Co=256
syntax enable
set number
set expandtab
set tabstop=4
set shiftwidth=4
set softtabstop=4
setlocal cursorline

" Autosave
" ------------------
let g:auto_save = 1

" Python support
" Let nvim know where the binaries are
let g:python_host_prog = '/usr/bin/python'
let g:python3_host_prog = '/usr/bin/python3'
let g:rainbow_active = 1 "set to 0 if you want to enable it later via :RainbowToggle
let g:ale_set_highlights = 0
let g:ale_echo_msg_format = '%linter%: %s'
let g:ale_linters = {
			\   'python': ['flake8',],
			\   'javascript': ['eslint'],
			\   'html': ['eslint'],
			\   'go': ['go build', 'gometalinter'],
			\   'clojure': ['clj-kondo'],
			\}
let g:ale_python_black_executable = '~/.virtualenvs/neovim/bin/black'
let g:ale_javascript_prettier_use_global = 1
let g:ale_fixers = {
			\   '*': ['remove_trailing_lines', 'trim_whitespace'],
			\   'python': ['isort', 'black'],
			\   'javascriptreact': ['prettier',],
			\   'htmldjango': ['html-beautify'],
			\   'go': ['goimports'],
			\   'javascript': ['prettier',],
			\   'html': ['html-beautify'],
			\}
let g:ale_fix_on_save = 1
let g:onedark_termcolors=256
let g:indent_guides_enable_on_vim_startup = 1
" Start NERDTree and leave the cursor in it.
autocmd VimEnter * NERDTree
set textwidth=80
au BufNewFile,BufRead *.py
			\ set tabstop=4
			\ softtabstop=4
			\ shiftwidth=4
			\ textwidth=80
			\ expandtab
			\ autoindent
			\ fileformat=unix
			\ foldmethod=indent

au BufRead, BufNewFile *.py,*.pyw,*.c,*.h match BadWhitespace /\s\+$/
au BufWritePre, BufNewFile * undojoin | gg=G
au BufRead, BufNewFile *.py | autopep8 --in-place --aggressive --aggressive
au BufWritePre, BufNewFile *.py | autopep8 --in-place --aggressive --aggressive

augroup fmt
  autocmd!
  autocmd BufWritePre * undojoin | Neoformat
augroup END

" Enable colorizer
