module Repo
  class << self
    attr_accessor :books, :authors
  end

  self.books = [
    {
      id: 'book-1',
      name: "Harry Potter and the Philosopher's Stone",
      page_count: 223,
      author_id: 'author-1'
    },
    {
      id: 'book-2',
      name: "Moby Dick",
      page_count: 635,
      author_id: 'author-2'
    }
  ]

  self.authors = [
    {
      id: 'author-1',
      first_name: 'Joanne',
      last_name: 'Rowling'
    },
    {
      id: 'author-2',
      first_name: 'Herman',
      last_name: 'Melville'
    }
  ]
end